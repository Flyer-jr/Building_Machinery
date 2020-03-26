package com.fly.repository.hibernateDaoImpl;

import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateCustomer;
import com.fly.repository.hibernateDAO.HibernateCustomerDAO;

import java.util.List;

public class HibernateCustomerDAOimpl implements HibernateCustomerDAO {
    @Override
    public List<HibernateCustomer> findAll() {
        return null;
    }

    @Override
    public HibernateCustomer findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public HibernateCustomer save(HibernateCustomer entity) {
        return null;
    }

    @Override
    public HibernateCustomer update(HibernateCustomer entity) {
        return null;
    }

    @Override
    public List<HibernateConstructionSite> findAllSitesByCustomer(String customerName) {
        return null;
    }
}
