package com.fly.repository.hibernateDaoImpl;

import com.fly.repository.hibernate.HibernateConstructionSite;
import com.fly.repository.hibernate.HibernateOrder;
import com.fly.repository.hibernateDAO.HibernateOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
@Qualifier("hibernateOrderDAOimpl")
public class HibernateOrderDAOimpl implements HibernateOrderDAO {

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<HibernateOrder> findAll() {
        return entityManager.createQuery("select ho from HibernateOrder ho", HibernateOrder.class).getResultList();
    }

    @Override
    public HibernateOrder findById(Long id) {
        return entityManager.find(HibernateOrder.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findById(id));

    }

    @Override
    public HibernateOrder save(HibernateOrder entity) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        return entityManager.find(HibernateOrder.class, entity.getId());
    }

    @Override
    public HibernateOrder update(HibernateOrder entity) {
        return null;
    }

}
