package com.fly.repository.dao;

import com.fly.repository.entities.Equipment;

public interface EquipmentDAO extends GenericDAO<Equipment, Long> {
    Equipment findByStoreNumber(Long storeNumber);

}
