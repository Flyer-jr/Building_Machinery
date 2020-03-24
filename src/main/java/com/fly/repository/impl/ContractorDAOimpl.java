package com.fly.repository.impl;

import com.fly.repository.dao.ContractorDAO;
import com.fly.repository.entities.Contractor;
import com.fly.repository.entities.User;
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
public class ContractorDAOimpl implements ContractorDAO {

    public static final String CONTRACTOR_ID = "id";
    public static final String CONTRACTOR_SHORT_NAME = "short_name";
    public static final String CONTRACTOR_FULL_NAME = "full_name";
    public static final String CONTRACTOR_ADRESS = "adress";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ContractorDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private Contractor getContractorRowMapper(ResultSet resultSet, int i) throws SQLException {

        Contractor contractor = new Contractor();

        contractor.setId(resultSet.getLong(CONTRACTOR_ID));
        contractor.setShortName(resultSet.getString(CONTRACTOR_SHORT_NAME));
        contractor.setFullName(resultSet.getString(CONTRACTOR_FULL_NAME));
        contractor.setAdress(resultSet.getString(CONTRACTOR_ADRESS));

        return contractor;


    }

    @Override
    public Contractor findContractorByShortName(String shortName) {
        return null;
    }

    @Override
    public List<Contractor> findAll() {
        final String findAllQuery = "select * from m_contractor";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getContractorRowMapper);

    }

    @Override
    public Contractor findById(Long id) {

        final String findQuery = "select * from m_contractor where id = :contractorId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("contractorId", id);
        return namedParameterJdbcTemplate.queryForObject(findQuery, parameterSource, this::getContractorRowMapper);
    }

    @Override
    public void delete(Long id) {
        final String deleteQuery = "DELETE * from m_contractor where id = :contractorId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("contractorId", id);
        namedParameterJdbcTemplate.update(deleteQuery, parameterSource);

    }

    @Override
    public Contractor save(Contractor entity) {

        final String saveQuery = "INSERT INTO m_contractor (short_name, full_name, adress)" +
                "VALUES (:shortName, :fullName, :adress)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("shortName", entity.getShortName());
        parameterSource.addValue("fullName", entity.getFullName());
        parameterSource.addValue("adress", entity.getAdress());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(saveQuery, parameterSource, keyHolder);

        Long createdContactorId = Objects.requireNonNull(keyHolder.getKey().longValue());

        return findById(createdContactorId);
    }

    @Override
    public Contractor update(Contractor entity) {

        final String updateQuery = "UPDATE m_contractor SET short_name = :shortName, full_name = :fullName" +
                "adress = :adress where id = :contractorId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("shortName", entity.getShortName());
        parameterSource.addValue("fullName", entity.getFullName());
        parameterSource.addValue("adress", entity.getAdress());
        parameterSource.addValue("contractorId", entity.getId());

        namedParameterJdbcTemplate.update(updateQuery, parameterSource);
        return findById(entity.getId());
    }
}
