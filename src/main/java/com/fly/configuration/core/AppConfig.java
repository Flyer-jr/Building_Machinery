package com.fly.configuration.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.fly")
@Import({DataBaseConfiguration.class, JdbsTemplateConfiguration.class})
public class AppConfig {

}
