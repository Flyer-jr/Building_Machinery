package com.fly.configuration.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("datasource")
@Getter
@Setter
public class DataBaseConfiguration {

  private String driverName;

  private String password;

  private String url;

  private String initialSize;

  private String username;

  private String maxActive;

  @Bean(value = "dataSource", destroyMethod = "close")
  @Scope("singleton")
  @Primary
  public BasicDataSource getDatasource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(driverName);
    dataSource.setPassword(password);
    dataSource.setUrl(url);
    dataSource.setInitialSize(Integer.valueOf(Objects.requireNonNull(initialSize)));
    dataSource.setUsername(username);
    dataSource.setMaxIdle(Integer.valueOf(Objects.requireNonNull(maxActive)));
    return dataSource;
  }
}
