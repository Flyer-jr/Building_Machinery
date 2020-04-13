package com.fly.repository.dao;

import com.fly.repository.entities.EquipmentProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentProducerRepository
    extends JpaRepository<EquipmentProducer, Long>, CrudRepository<EquipmentProducer, Long> {

  EquipmentProducer findEquipmentProducerByName(String name);
}
