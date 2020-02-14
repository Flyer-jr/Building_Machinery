package com.fly.repository.impl;

import com.fly.repository.EquipmentDAO;
import com.fly.repository.entities.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EquipmentDAOimpl implements EquipmentDAO {

    public static String EQUIPMENT_ID = "id";
    public static String EQUIPMENT_STORE_NUMBER = "store_number";
    public static String EQUIPMENT_MODEL = "model";
    public static String EQUIPMENT_IS_TAKEN = "is_taken";
    public static String EQUIPMENT_PRODUCER_ID = "producer_id";

    private Equipment getEquipmentRowMapper (ResultSet resultSet, int i) throws SQLException {

        Equipment equipment = new Equipment();

        equipment.setId(resultSet.getLong(EQUIPMENT_ID));
        equipment.setStoreNumber(resultSet.getLong(EQUIPMENT_STORE_NUMBER));
        equipment.setModel(resultSet.getString(EQUIPMENT_MODEL));
        equipment.setTaken(resultSet.getBoolean(EQUIPMENT_IS_TAKEN));
        equipment.setProducerId(resultSet.getLong(EQUIPMENT_PRODUCER_ID));

        return equipment;

    }
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public EquipmentDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Equipment findByStoreNumber(Long storeNumber) {
        return null;
    }

    @Override
    public List<Equipment> findAll() {
        final String findAllQuery = "select * from m_equipment";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getEquipmentRowMapper);
    }

    @Override
    public Equipment findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Equipment save(Equipment entity) {
        return null;
    }

    @Override
    public Equipment update(Equipment entity) {
        return null;
    }
}
