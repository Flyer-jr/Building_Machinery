package com.fly.repository.hibernateDAO;

import com.fly.repository.dao.GenericDAO;
import com.fly.repository.hibernate.HibernateEquipment;

import java.util.List;

public interface HibernateEquipmentDAO extends GenericDAO<HibernateEquipment, Long> {

    List<HibernateEquipment> showAllEquipment ();



}
