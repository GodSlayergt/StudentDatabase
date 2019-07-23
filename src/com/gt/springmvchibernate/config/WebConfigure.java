
package com.gt.springmvchibernate.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.gt.springmvchibernate")
@PropertySource({"classpath:Errors.properties","classpath:DataBaseConfig.properties"})
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class WebConfigure implements WebMvcConfigurer {
	
	@Autowired
	public Environment env;
	
	@Bean
	public BasicDataSource dataSource()
	{
		
		BasicDataSource ds = new BasicDataSource();
		ds.setUsername(env.getProperty("user"));
		ds.setPassword(env.getProperty("password"));
		ds.setDriverClassName(env.getProperty("driverclassname"));
		ds.setUrl(env.getProperty("url"));
		ds.setMaxActive(100);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.gt.springmvchibernate.Student");
		factory.setHibernateProperties(hibernateProperties());
		return factory;

	}
	
	Properties hibernateProperties() {
        return new Properties() {
            
			private static final long serialVersionUID = 1L;

			{
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
                setProperty("hibernate.show_sql", "true");
              
			}
        };
    }
	
	@Bean
	@Autowired
	public HibernateTransactionManager transaction(SessionFactory sf)
	{
		HibernateTransactionManager txm= new HibernateTransactionManager();
		txm.setSessionFactory(sf);
		return txm;
	}
	
	 
	
	@Bean 
	public InternalResourceViewResolver resolver()
	{
		InternalResourceViewResolver rs=new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		return rs;
	}

}
