package net.ycod3r.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import net.ycod3r.converters.BasicDateConverter;
import net.ycod3r.converters.ClasseFormatter;
import net.ycod3r.converters.EvaluationFormatter;
import net.ycod3r.converters.FrenchDateFormatter;
import net.ycod3r.converters.LocalDateConverter;
import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafWebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private ClasseFormatter classeFormatter;
	
	@Autowired
	private EvaluationFormatter evaluationFormatter;

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}

	@Bean
	public ITemplateEngine templateEngine() {
		// TODO Auto-generated method stub
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setDialect(new LayoutDialect());
		return templateEngine;
	}

	private ITemplateResolver templateResolver() {
		// TODO Auto-generated method stub
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setCacheable(false);
		templateResolver.setSuffix("html");
		templateResolver.setPrefix("classpath:/templates/");
		return templateResolver;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new LocalDateConverter("dd/MM/yyyy"));
		registry.addConverter(new LocalDateConverter("dd-MM-yyyy"));
		//registry.addConverter(new BasicDateConverter("dd/MM/yyyy"));
		registry.addFormatter(new FrenchDateFormatter("dd/MM/yyyy"));
		registry.addFormatter(classeFormatter);
		registry.addFormatter(evaluationFormatter);
		
		super.addFormatters(registry);
	}

}
