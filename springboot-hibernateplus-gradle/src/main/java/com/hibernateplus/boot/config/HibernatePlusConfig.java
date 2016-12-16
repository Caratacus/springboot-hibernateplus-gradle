package com.hibernateplus.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import com.baomidou.hibernateplus.HibernateSpringSessionFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class HibernatePlusConfig {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	@Bean("sessionFactory")
	public HibernateSpringSessionFactoryBean hibernateSpringSessionFactoryBean() throws IOException {
		HibernateSpringSessionFactoryBean hibernatePlus = new HibernateSpringSessionFactoryBean();
		hibernatePlus.setType("master");
		hibernatePlus.setDataSource(dataSource);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.put("hibernate.show_sql", false);
		hibernateProperties.put("hibernate.format_sql", false);
		hibernateProperties.put("hibernate.use_sql_comments", true);
		hibernatePlus.setHibernateProperties(hibernateProperties);
		hibernatePlus.setPackagesToScan("com.hibernateplus.boot.po");
		hibernatePlus.afterPropertiesSet();
		return hibernatePlus;
	}
}
