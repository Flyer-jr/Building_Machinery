package com.fly.repository.impl;

import com.fly.configuration.core.JdbsTemplateConfiguration;
import com.fly.repository.GenericDAO;
import com.fly.repository.entities.ConstructionSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class ConstructionSiteDAOimpl implements GenericDAO<ConstructionSite, Long> {

    public static final String CONSTRUCTION_SITE_ID="id";
    public static final String CONSTRUCTION_SITE_FULL_NAME="full_name";
    public static final String CONSTRUCTION_SITE_SHORT_NAME="short_name";
    public static final String CONSTRUCTION_SITE_CUSTOMER_ID="customer_id";
    public static final String CONSTRUCTION_SITE_RESPONSIBLE_ID="responsible_id";
    public static final String CONSTRUCTION_SITE_CONTRACTOR_ID="contractor_id";
    public static final String CONSTRUCTION_SITE_DATE_OF_START="date_of_start";
    public static final String CONSTRUCTION_SITE_DATE_OF_FINISH="date_of_finish";

    private JdbsTemplateConfiguration jdbsTemplateConfiguration;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ConstructionSiteDAOimpl(JdbsTemplateConfiguration jdbsTemplateConfiguration,
                                   NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbsTemplateConfiguration = jdbsTemplateConfiguration;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<ConstructionSite> findAll() {
        return null;
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
}
