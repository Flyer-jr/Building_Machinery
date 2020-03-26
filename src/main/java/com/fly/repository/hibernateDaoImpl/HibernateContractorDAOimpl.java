package com.fly.repository.hibernateDaoImpl;

import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateContractor;
import com.fly.repository.hibernateDAO.HibernateContractorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
@Qualifier("hibernateContractorDAOimpl")
public class HibernateContractorDAOimpl implements HibernateContractorDAO {

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<HibernateContractor> findAll() {
        return entityManager.createQuery("select hc from HibernateContractor hc", HibernateContractor.class).getResultList();
    }

    @Override
    public HibernateContractor findById(Long id) {
        return entityManager.find(HibernateContractor.class, id);
    }

    @Override
    public void delete(Long id) {

        entityManager.remove(findById(id));

    }

    @Override
    public HibernateContractor save(HibernateContractor entity) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        return entityManager.find(HibernateContractor.class, entity.getId());
    }

    @Override
    public HibernateContractor update(HibernateContractor entity) {
        return null;
    }

    @Override
    public List<HibernateConstructionSite> findAllSitesByContractor(String contractorName) {
        return null;
    }
}
