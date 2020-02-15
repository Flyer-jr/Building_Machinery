package com.fly.repository.impl;

import com.fly.repository.dao.EquipmentDAO;
import com.fly.repository.entities.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

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
        final String findByNumber = "select * from m_equipment where store_number = :storeNumber";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("storeNumber", storeNumber);

        return namedParameterJdbcTemplate.queryForObject(findByNumber,parameterSource, this::getEquipmentRowMapper);
    }

    @Override
    public List<Equipment> findAll() {
        final String findAllQuery = "select * from m_equipment";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getEquipmentRowMapper);
    }

    @Override
    public Equipment findById(Long id) {

        final String findById = "select * from m_equipment where id = :equipmnetId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("equipmentId", id);

        return namedParameterJdbcTemplate.queryForObject(findById,parameterSource, this::getEquipmentRowMapper);
    }

    @Override
    public void delete(Long id) {

        final String deleteQuery = "DELETE from m_equipment where id = :equipmentId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("equipmentId", id);
        namedParameterJdbcTemplate.update(deleteQuery,parameterSource);

    }

    @Override
    public Equipment save(Equipment entity) {

        final String saveQuery = "INSERT INTO m_equipment (store_number, model, is_taken, producer_id)" +
                "VALUES (:storeNumber, :model, :isTaken, :producerId)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("storeNumber", entity.getStoreNumber());
        parameterSource.addValue("model", entity.getModel());
        parameterSource.addValue("isTaken", entity.isTaken());
        parameterSource.addValue("producerId", entity.getProducerId());

        namedParameterJdbcTemplate.update(saveQuery,parameterSource,keyHolder);

        long createdEquipmentId = Objects.requireNonNull(keyHolder.getKey().longValue());

        return findById(createdEquipmentId);
    }

    @Override
    public Equipment update(Equipment entity) {

        final String updateQuery = "UPDATE m_equipment set store_number = :storeNumber, model = :model," +
                " is_taken = isTaken, producer_id = :producerId where id = :Id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("storeNumber", entity.getStoreNumber());
        parameterSource.addValue("mode", entity.getModel());
        parameterSource.addValue("isTaken", entity.isTaken());
        parameterSource.addValue("id", entity.getId());

        namedParameterJdbcTemplate.update(updateQuery, parameterSource);
        return findById(entity.getId());
    }
}
