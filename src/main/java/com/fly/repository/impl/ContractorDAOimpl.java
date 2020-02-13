package com.fly.repository.impl;

import com.fly.repository.ContractorDAO;
import com.fly.repository.entities.Contractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContractorDAOimpl implements ContractorDAO {

    public static final String CONTRACTOR_ID="id";
    public static final String CONTRACTOR_SHORT_NAME="short_name";
    public static final String CONTRACTOR_FULL_NAME="full_name";
    public static final String CONTRACTOR_ADRESS="adress";

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
    public Contractor findByShortName(String shortName) {
        return null;
    }

    @Override
    public List<Contractor> findAll() {
        return null;
    }

    @Override
    public Contractor findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Contractor save(Contractor entity) {
        return null;
    }

    @Override
    public Contractor update(Contractor entity) {
        return null;
    }
}
