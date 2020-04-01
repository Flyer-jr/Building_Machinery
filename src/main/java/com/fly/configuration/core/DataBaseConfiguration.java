package com.fly.configuration.core;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dataBaseConfiguration.properties")
public class DataBaseConfiguration {
    @Autowired
    private Environment properties;

    @Bean(value = "basicDataSource", destroyMethod = "close")
    @Scope("singleton")
    public BasicDataSource getDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName(properties.getProperty("driverName"));
        basicDataSource.setUrl(properties.getProperty("url"));
        basicDataSource.setUsername(properties.getProperty("login"));
        basicDataSource.setPassword(properties.getProperty("password"));
        basicDataSource.setInitialSize(Integer.valueOf(properties.getProperty("initialSize")));
        basicDataSource.setMaxIdle(Integer.valueOf(properties.getProperty("maxActive")));
        return basicDataSource;


    }
}
