package com.fly.repository.hibernateDAO;

import com.fly.repository.dao.GenericDAO;
import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateContractor;

import java.util.List;

public interface HibernateContractorDAO extends GenericDAO<HibernateContractor, Long> {

    List<HibernateConstructionSite> findAllSitesByContractor(String contractorName);

}
