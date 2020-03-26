package com.fly.repository.hibernateDaoImpl;

import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateUser;
import com.fly.repository.hibernateDAO.HibernateConstructionSiteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
@Qualifier("hibernateConstructionSiteDAOimpl")
public class HibernateConstructionSiteDAOimpl implements HibernateConstructionSiteDAO {

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;


    @Override
    public List<HibernateConstructionSite> findAll() {

        return entityManager.createQuery("select hcs from HibernateConstructionSite hcs", HibernateConstructionSite.class).getResultList();

    }

    @Override
    public HibernateConstructionSite findById(Long id) {

        return entityManager.find(HibernateConstructionSite.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public HibernateConstructionSite save(HibernateConstructionSite entity) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        return entityManager.find(HibernateConstructionSite.class, entity.getId());
    }

    @Override
    public HibernateConstructionSite update(HibernateConstructionSite entity) {
        return null;
    }

    @Override
    public List<HibernateConstructionSite> findSiteByCustomer(String customerName) {
        return null;
    }
}
