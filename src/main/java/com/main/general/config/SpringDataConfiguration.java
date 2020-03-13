package com.main.general.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
@ComponentScan(basePackages = {"com.main.general"})
@EnableWebMvc
//@ImportResource("classpath:/pom.xml")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringDataConfiguration {
    @Autowired
    Environment env;

    @Bean
    @Primary
    public DataSource mainDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.main.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.main.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.main.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.main.datasource.password"));
        return dataSource;
    }

    @Bean
    public DataSource tenantDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.tenant.datasource.driver-class-name"));
        //fetch database url, username and password config from database
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplateMain(@Qualifier("mainDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplateTenant(@Qualifier("tenantDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }
}
