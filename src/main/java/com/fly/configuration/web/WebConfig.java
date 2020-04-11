package com.fly.configuration.web;

import com.fly.controller.convertor.contractor.ContractorChangeRequestConverter;
import com.fly.controller.convertor.contractor.ContractorCreateRequestConverter;
import com.fly.controller.convertor.customer.CustomerChangeRequestConverter;
import com.fly.controller.convertor.customer.CustomerCreateRequestConverter;
import com.fly.controller.convertor.order.OrderCreateRequestConverter;
import com.fly.controller.convertor.user.UserChangeRequestConverter;
import com.fly.controller.convertor.user.UserCreateRequestConverter;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private PasswordEncoder passwordEncoder;

  private final UserRepository userRepository;

  private final ConstructionSiteRepository siteRepository;

  private final EquipmentRepository equipmentRepository;
  //    @Override
  //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //        registry.addResourceHandler("/WEB-INF/view/**").addResourceLocations("/view/");
  //    }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new UserCreateRequestConverter(passwordEncoder));
    registry.addConverter(new UserChangeRequestConverter());
    registry.addConverter(new ContractorCreateRequestConverter());
    registry.addConverter(new ContractorChangeRequestConverter());
    registry.addConverter(new CustomerCreateRequestConverter());
    registry.addConverter(new CustomerChangeRequestConverter());
    registry.addConverter(new OrderCreateRequestConverter(userRepository, siteRepository, equipmentRepository));
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
