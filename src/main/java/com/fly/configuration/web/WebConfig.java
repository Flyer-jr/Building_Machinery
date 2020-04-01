package com.fly.configuration.web;

import com.fly.controller.convertor.contractor.ContractorChangeRequestConverter;
import com.fly.controller.convertor.contractor.ContractorCreateRequestConverter;
import com.fly.controller.convertor.customer.CustomerChangeRequestConverter;
import com.fly.controller.convertor.customer.CustomerCreateRequestConverter;
import com.fly.controller.convertor.user.UserChangeRequestConverter;
import com.fly.controller.convertor.user.UserCreateRequestConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
  //    @Override
  //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //        registry.addResourceHandler("/WEB-INF/view/**").addResourceLocations("/view/");
  //    }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new UserCreateRequestConverter());
    registry.addConverter(new UserChangeRequestConverter());
    registry.addConverter(new ContractorCreateRequestConverter());
    registry.addConverter(new ContractorChangeRequestConverter());
    registry.addConverter(new CustomerCreateRequestConverter());
    registry.addConverter(new CustomerChangeRequestConverter());
  }

  //    @Bean
  //    public ViewResolver viewResolver(){
  //        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
  //        viewResolver.setPrefix("/WEB-INF/view/");
  //        viewResolver.setSuffix(".jsp");
  //        viewResolver.setViewClass(JstlView.class);
  //        return viewResolver;
  //    }

}
