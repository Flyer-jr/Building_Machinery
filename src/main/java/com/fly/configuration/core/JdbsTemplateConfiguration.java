package com.fly.configuration.core;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("com.fly")
public class JdbsTemplateConfiguration {

    @Autowired
    @Qualifier("basicDataSource")
    private BasicDataSource basicDataSource;

    @Bean("namedJdbcTemplate")
    public NamedParameterJdbcTemplate getNamedJdbcTemplate() {return new NamedParameterJdbcTemplate(basicDataSource);}

    @Bean("transactionManager")
    public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);}

}
