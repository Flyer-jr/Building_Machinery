package com.fly.repository.hibernateDaoImpl;

import com.fly.repository.hibernate.HibernateEquipment;
import com.fly.repository.hibernate.HibernateOrder;
import com.fly.repository.hibernateDAO.HibernateEquipmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Qualifier("hibernateEquipmentDAOimpl")
public class HibernateEquipmentDAOimpl implements HibernateEquipmentDAO {

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<HibernateEquipment> showAllEquipment() {
        return null;
    }

    @Override
    public List<HibernateEquipment> findAll() {
        return entityManager.createQuery("select he from HibernateEquipment he", HibernateEquipment.class).getResultList();
    }

    @Override
    public HibernateEquipment findById(Long id) {
        return entityManager.find(HibernateEquipment.class,id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public HibernateEquipment save(HibernateEquipment entity) {
        return null;
    }

    @Override
    public HibernateEquipment update(HibernateEquipment entity) {
        return null;
    }
}
