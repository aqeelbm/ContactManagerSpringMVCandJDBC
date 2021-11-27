package com.code.contact.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.code.contact.dao.ContactDAO;
import com.code.contact.dao.ContactDAOImpl;

/**
 * @author Aqeel
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.code.contact")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("--MySql Id--");
		dataSource.setPassword("--MySql Password--");
		
		return dataSource;
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) { }

	@Override
	public Validator getValidator() {
		return null;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) { }

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) { }

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) { }

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) { }

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		return null;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) { }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {	}
	
}