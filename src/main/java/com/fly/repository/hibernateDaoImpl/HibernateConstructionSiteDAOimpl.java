package com.fly.repository.hibernateDaoImpl;

import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateUser;
import com.fly.repository.hibernateDAO.HibernateConstructionSiteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Qualifier("hibernateConstructionSiteDAOimpl")
public class HibernateConstructionSiteDAOimpl implements HibernateConstructionSiteDAO {

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;


    @Override
    public List<HibernateConstructionSite> findAll() {
        System.out.println(entityManager.toString());
        return entityManager.createQuery("select hcs from HibernateConstructionSite hcs", HibernateConstructionSite.class).getResultList();

    }

    @Override
    public HibernateConstructionSite findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public HibernateConstructionSite save(HibernateConstructionSite entity) {
        return null;
    }

    @Override
    public HibernateConstructionSite update(HibernateConstructionSite entity) {
        return null;
    }
}
