package com.fly;

import com.fly.configuration.core.DataBaseConfiguration;
import com.fly.configuration.core.JdbsTemplateConfiguration;
import com.fly.configuration.swagger.SwaggerConfiguration;
import com.fly.configuration.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@EnableSwagger2WebMvc
@EnableAsync
@EnableJpaRepositories
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(
    scanBasePackages = {"com.fly"},
    exclude = {JacksonAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Import({
  WebConfig.class,
  DataBaseConfiguration.class,
  JdbsTemplateConfiguration.class,
  SwaggerConfiguration.class
})
public class SpringBootStarter extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootStarter.class, args);
  }

  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
        new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setPackagesToScan("com.fly");

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
    entityManagerFactoryBean.setJpaProperties(getAdditionalProperties());
    return entityManagerFactoryBean;
  }

  private Properties getAdditionalProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
    properties.put("hibernate.hbm2ddl.auto", "update");
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.archive.autodetection", "class, hbm");
    properties.put(
            "current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
    return properties;
  }







}
