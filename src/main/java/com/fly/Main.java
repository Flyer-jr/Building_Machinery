//package com.fly;
//
//import com.fly.configuration.core.AppConfig;
//import com.fly.repository.dao.*;
//import com.fly.repository.entities.*;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//    public static void main(String[] args) {
//
//
//    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//    UserDAO userDAO = (UserDAO) context.getBean("userDAOimpl");
//        for (User user: userDAO.findAll()) {
//            System.out.println(user.toString());}
//
//    OrderDAO orderDAO = (OrderDAO) context.getBean("orderDAOimpl");
//        for (Order order: orderDAO.findAll()) {
//            System.out.println(order.toString());}
//
//    EquipmentDAO equipmentDAO = (EquipmentDAO) context.getBean("equipmentDAOimpl");
//        for (Equipment equipment: equipmentDAO.findAll()) {
//            System.out.println(equipment.toString());}
//
//    CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAOimpl");
//        for (Customer customer: customerDAO.findAll()) {
//            System.out.println(customer.toString());}
//
//    ContractorDAO contractorDAO = (ContractorDAO) context.getBean("contractorDAOimpl");
//        for (Contractor contractor: contractorDAO.findAll()) {
//            System.out.println(contractor.toString());}
//
//    ConstructionSiteDAO constructionSiteDAO = (ConstructionSiteDAO) context.getBean("constructionSiteDAOimpl");
//        for (ConstructionSite constructionSite: constructionSiteDAO.findAll()) {
//            System.out.println(constructionSite.toString());}
//    }
//
//
//
//}
