package net.ycod3r.config;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.ycod3r.config.PrincipalUser;
import net.ycod3r.domain.User;
import net.ycod3r.repository.UserRepo;

@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserRepo userRepo;
	
	public CustomUserDetailsService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			User user = userRepo.findByUsername(username);
			if (user == null){
				return null;
			}
			
			return new PrincipalUser(user);
			
		} 
		catch(Exception e) {
			throw new UsernameNotFoundException("user not found with the provided username");
		}
	}

}
