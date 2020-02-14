package com.fly.repository.impl;

import com.fly.repository.ConstructionSiteDAO;
import com.fly.repository.GenericDAO;
import com.fly.repository.entities.ConstructionSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConstructionSiteDAOimpl implements ConstructionSiteDAO {

    public static final String CONSTRUCTION_SITE_ID="id";
    public static final String CONSTRUCTION_SITE_FULL_NAME="full_name";
    public static final String CONSTRUCTION_SITE_SHORT_NAME="short_name";
    public static final String CONSTRUCTION_SITE_CUSTOMER_ID="customer_id";
    public static final String CONSTRUCTION_SITE_RESPONSIBLE_ID="responsible_id";
    public static final String CONSTRUCTION_SITE_CONTRACTOR_ID="contractor_id";
    public static final String CONSTRUCTION_SITE_DATE_OF_START="date_of_start";
    public static final String CONSTRUCTION_SITE_DATE_OF_FINISH="date_of_finish";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ConstructionSiteDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
           this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    private ConstructionSite getSiteRowMapper(ResultSet resultSet, int i) throws SQLException {

        ConstructionSite constructionSite = new ConstructionSite();

        constructionSite.setId(resultSet.getLong(CONSTRUCTION_SITE_ID));
        constructionSite.setFullName(resultSet.getString(CONSTRUCTION_SITE_FULL_NAME));
        constructionSite.setShortName(resultSet.getString(CONSTRUCTION_SITE_SHORT_NAME));
        constructionSite.setCustomerId(resultSet.getLong(CONSTRUCTION_SITE_CUSTOMER_ID));
        constructionSite.setResponsibleId(resultSet.getLong(CONSTRUCTION_SITE_RESPONSIBLE_ID));
        constructionSite.setContractorId(resultSet.getLong(CONSTRUCTION_SITE_CONTRACTOR_ID));
        constructionSite.setDateOfStart(resultSet.getDate(CONSTRUCTION_SITE_DATE_OF_START));
        constructionSite.setDateOfFinish(resultSet.getDate(CONSTRUCTION_SITE_DATE_OF_FINISH));
        return constructionSite;
    }

    @Override
    public List<ConstructionSite> findAll() {
        final String findAllQuery = "select * from m_construction_site";
        return namedParameterJdbcTemplate.query(findAllQuery, this::getSiteRowMapper);

    }

    @Override
    public ConstructionSite findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ConstructionSite save(ConstructionSite entity) {
        return null;
    }

    @Override
    public ConstructionSite update(ConstructionSite entity) {
        return null;
    }

    @Override
    public ConstructionSite findByShortName(String shortName) {
        return null;
    }
}
