package net.ycod3r.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.ycod3r.repository.UserRepo;

@Configuration
@EnableWebSecurity
public class MySecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserRepo userRepo;
	
	@Bean 
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean())
		.passwordEncoder(passwordEncoder());
	}
	
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new CustomUserDetailsService(userRepo);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/webjars/**","/users/new","/img/**").permitAll()
			//.antMatchers("/admin/**").hasAuthority("ADMIN")
			.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}

}
