package com.fly.repository.impl;

import com.fly.repository.dao.ConstructionSiteDAO;
import com.fly.repository.entities.ConstructionSite;
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
public class ConstructionSiteDAOimpl implements ConstructionSiteDAO {

    public static final String CONSTRUCTION_SITE_ID = "id";
    public static final String CONSTRUCTION_SITE_FULL_NAME = "full_name";
    public static final String CONSTRUCTION_SITE_SHORT_NAME = "short_name";
    public static final String CONSTRUCTION_SITE_CUSTOMER_ID = "customer_id";
    public static final String CONSTRUCTION_SITE_RESPONSIBLE_ID = "responsible_id";
    public static final String CONSTRUCTION_SITE_CONTRACTOR_ID = "contractor_id";
    public static final String CONSTRUCTION_SITE_DATE_OF_START = "date_of_start";
    public static final String CONSTRUCTION_SITE_DATE_OF_FINISH = "date_of_finish";

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

        final String findByIdQuery = "SELECT * FROM m_construction_site WHERE id = :siteId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("siteId", id);

        return namedParameterJdbcTemplate.queryForObject(findByIdQuery, parameterSource, this::getSiteRowMapper);
    }

    @Override
    public void delete(Long id) {

        final String deleteQuery = "DELETE FROM m_construction_site WHERE id = :siteId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("siteId", id);
        namedParameterJdbcTemplate.update(deleteQuery, parameterSource);

    }

    @Override
    public ConstructionSite save(ConstructionSite entity) {

        final String saveSiteQuery = "INSERT INTO m_construction_site (full_name, short_name, customer_id, responsible_id, contractor_id, date_of_start, date_of_finish) " +
                "VALUES (:fuulName, :shortName, :customerId, :responsibleId, :contractorId, :dateOfStart, :dateOfFinish)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fullName", entity.getFullName());
        parameterSource.addValue("shortName", entity.getShortName());
        parameterSource.addValue("customerId", entity.getCustomerId());
        parameterSource.addValue("responsibleId", entity.getResponsibleId());
        parameterSource.addValue("contractorId", entity.getContractorId());
        parameterSource.addValue("dateOfStart", entity.getDateOfStart());
        parameterSource.addValue("dateOfFinish", entity.getDateOfFinish());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(saveSiteQuery, parameterSource, keyHolder);
        Long generatedNewSiteId = Objects.requireNonNull(keyHolder.getKey().longValue());
        return findById(generatedNewSiteId);
    }

    @Override
    public ConstructionSite update(ConstructionSite entity) {

        final String updateQuery = "UPDATE m_construction_site SET full_name = :fullName, short_name = :shortName" +
                "customer_id = :customerId, responsible_id = :responsibleId, contractor_id = :contractorId, " +
                "date_of_start = :dateOfStart, date_of_finish = :dateOfFinish WHERE id = :siteId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fullName", entity.getFullName());
        parameterSource.addValue("shortName", entity.getShortName());
        parameterSource.addValue("customerId", entity.getCustomerId());
        parameterSource.addValue("responsibleId", entity.getResponsibleId());
        parameterSource.addValue("contractorId", entity.getContractorId());
        parameterSource.addValue("dateOfStart", entity.getDateOfStart());
        parameterSource.addValue("dateOfFinish", entity.getDateOfFinish());
        parameterSource.addValue("siteId", entity.getId());
        namedParameterJdbcTemplate.update(updateQuery, parameterSource);
        return findById(entity.getId());
    }

    @Override
    public ConstructionSite findSiteByShortName(String shortName) {

        final String findByShortNameQuery = "SELECT * FROM m_construction_site WHERE " +
                "lower(short_name) LIKE lower(:shortName)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("shortName", shortName);

        return namedParameterJdbcTemplate.queryForObject(findByShortNameQuery, parameterSource, this::getSiteRowMapper);
    }
}
