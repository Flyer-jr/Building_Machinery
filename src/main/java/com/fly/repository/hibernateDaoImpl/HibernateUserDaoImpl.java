package com.fly.repository.hibernateDaoImpl;

import com.fly.repository.hibernate.HibernateUser;
import com.fly.repository.hibernateDAO.HibernateUserDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Qualifier("hibernateUserDAOImpl")
public class HibernateUserDaoImpl implements HibernateUserDAO {


    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<HibernateUser> findAll() {

        return entityManager.createQuery("select hu from HibernateUser hu", HibernateUser.class).getResultList();

    }

    @Override
    public HibernateUser findById(Long id) {
        return entityManager.find(HibernateUser.class, id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public HibernateUser save(HibernateUser entity) {
        return null;
    }

    @Override
    public HibernateUser update(HibernateUser entity) {
        return null;
    }
}
