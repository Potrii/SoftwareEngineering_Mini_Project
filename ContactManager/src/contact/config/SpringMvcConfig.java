package contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import contact.dao.ContactDAO;
import contact.dao.ContactDAOImplementation;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "contact")
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		dataSource.setUsername("root");
		dataSource.setPassword("mouse69");
		
		return dataSource;
	}
	
	
	@Bean
	public ViewResolver getViewResolver() {
		
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		
		return (ViewResolver) resolver;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		
		return new ContactDAOImplementation(getDataSource());
		
		
	}
}
