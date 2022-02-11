package com.nb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nb.spring.common.filter.DirectAccessFilter;

@EnableScheduling
@SpringBootApplication
public class Gdj41NbifFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Gdj41NbifFinalApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean setFilterRegistration() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new DirectAccessFilter());
		
		filterRegistrationBean.addUrlPatterns("/product/*");
		filterRegistrationBean.addUrlPatterns("/member/*");
		filterRegistrationBean.addUrlPatterns("/report/*");
		filterRegistrationBean.addUrlPatterns("/admin/*");
		
		return filterRegistrationBean;
	}

}
