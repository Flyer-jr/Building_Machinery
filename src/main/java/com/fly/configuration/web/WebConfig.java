package com.fly.configuration.web;

import com.fly.controller.convertor.constructionSite.ConstructionSiteChangeRequestConverter;
import com.fly.controller.convertor.constructionSite.ConstructionSiteCreateRequestConverter;
import com.fly.controller.convertor.contractor.ContractorChangeRequestConverter;
import com.fly.controller.convertor.contractor.ContractorCreateRequestConverter;
import com.fly.controller.convertor.customer.CustomerChangeRequestConverter;
import com.fly.controller.convertor.customer.CustomerCreateRequestConverter;
import com.fly.controller.convertor.equipment.EquipmentChangeRequestConverter;
import com.fly.controller.convertor.equipment.EquipmentCreateRequestConverter;
import com.fly.controller.convertor.equipmentProducer.EquipmentProducerChangeRequestConverter;
import com.fly.controller.convertor.equipmentProducer.EquipmentProducerCreateRequestConverter;
import com.fly.controller.convertor.order.OrderCreateRequestConverter;
import com.fly.controller.convertor.user.UserChangeRequestConverter;
import com.fly.controller.convertor.user.UserCreateRequestConverter;
import com.fly.repository.dao.ConstructionSiteRepository;
import com.fly.repository.dao.EquipmentRepository;
import com.fly.repository.dao.UserRepository;
import com.fly.service.constructionSite.ConstructionSiteValidationService;
import com.fly.service.equipment.EquipmentValidationService;
import com.fly.service.order.OrderValidationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.access.CachedDomainDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private PasswordEncoder passwordEncoder;
  private final ConstructionSiteValidationService constructionSiteValidationService;
  private final EquipmentValidationService equipmentValidationService;
  private final OrderValidationService orderValidationService;

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new UserCreateRequestConverter(passwordEncoder));
    registry.addConverter(new UserChangeRequestConverter());
    registry.addConverter(new ContractorCreateRequestConverter());
    registry.addConverter(new ContractorChangeRequestConverter());
    registry.addConverter(new CustomerCreateRequestConverter());
    registry.addConverter(new CustomerChangeRequestConverter());
    registry.addConverter(new EquipmentProducerCreateRequestConverter());
    registry.addConverter(new EquipmentProducerChangeRequestConverter());
    registry.addConverter(new ConstructionSiteCreateRequestConverter(constructionSiteValidationService));
    registry.addConverter(new ConstructionSiteChangeRequestConverter(constructionSiteValidationService));
    registry.addConverter(new EquipmentCreateRequestConverter(equipmentValidationService));
    registry.addConverter(new EquipmentChangeRequestConverter(equipmentValidationService));
    registry.addConverter(new OrderCreateRequestConverter(orderValidationService));
    registry.addConverter(new OrderCreateRequestConverter(orderValidationService));

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
