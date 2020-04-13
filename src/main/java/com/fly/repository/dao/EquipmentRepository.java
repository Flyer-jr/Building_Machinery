package com.fly.repository.dao;

import com.fly.repository.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository
    extends JpaRepository<Equipment, Long>, CrudRepository<Equipment, Long> {

  Equipment findEquipmentByStoreNumber(String storeNumber);
}
