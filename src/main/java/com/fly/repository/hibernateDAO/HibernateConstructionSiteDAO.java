package com.fly.repository.hibernateDAO;

import com.fly.repository.dao.GenericDAO;
import com.fly.repository.hibernate.HibernateConstructionSite;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HibernateConstructionSiteDAO extends GenericDAO<HibernateConstructionSite, Long> {

    List<HibernateConstructionSite> findSiteByCustomer(String customerName);

}
