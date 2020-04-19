//package com.fly.service.user;
//
//import com.fly.controller.requests.user.UserCreateRequest;
//import com.fly.repository.dao.UserRepository;
//import com.fly.repository.entities.User;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.ConversionService;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//@NoArgsConstructor
//public class UserAuthenticationService {
//    @Autowired
//    private UserRepository userRepository;
//    private ConversionService conversionService;
//
//
//    public String registerUser(UserCreateRequest createRequest){
//        if (userRepository.findUserByLoginIgnoreCase(createRequest.getLogin()).isEmpty() ||
//        userRepository.findUserByEMAilIgnoreCase(createRequest.getEMail()).isEmpty()) {
//            userRepository.saveAndFlush(conversionService.convert(createRequest, User.class));
//
//
//
//
//
//
//        }
//    }
//}
