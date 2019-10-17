package com.arep.webpage;

import com.arep.webpage.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebPageApplication {

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/taskPlanner/users/*");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebPageApplication.class, args);
	}

}
