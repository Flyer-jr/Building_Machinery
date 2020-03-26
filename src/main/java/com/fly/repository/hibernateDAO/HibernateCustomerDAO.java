package com.fly.repository.hibernateDAO;

import com.fly.repository.dao.GenericDAO;
import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateCustomer;

import java.util.List;

public interface HibernateCustomerDAO extends GenericDAO<HibernateCustomer, Long> {

    List<HibernateConstructionSite> findAllSitesByCustomer(String customerName);

}
