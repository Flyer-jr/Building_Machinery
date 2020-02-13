package com.fly.repository.entities;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;
import java.util.Objects;

public class ConstructionSite {
    private Long id;
    private String fullName;
    private String shortName;
    private Long customerId;
    private Long responsibleId;
    private Long contractorId;
    private Date dateOfStart;
    private Date dateOfFinish;

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getFullName () {
        return fullName;
    }

    public void setFullName ( String fullName ) {
        this.fullName = fullName;
    }

    public String getShortName () {
        return shortName;
    }

    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }

    public Long getCustomerId () {
        return customerId;
    }

    public void setCustomerId ( Long customerId ) {
        this.customerId = customerId;
    }

    public Long getResponsibleId () {
        return responsibleId;
    }

    public void setResponsibleId ( Long responsibleId ) {
        this.responsibleId = responsibleId;
    }

    public Long getContractorId () {
        return contractorId;
    }

    public void setContractorId ( Long contractorId ) {
        this.contractorId = contractorId;
    }

    public Date getDateOfStart () {
        return dateOfStart;
    }

    public void setDateOfStart ( Date dateOfStart ) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfFinish () {
        return dateOfFinish;
    }

    public void setDateOfFinish ( Date dateOfFinish ) {
        this.dateOfFinish = dateOfFinish;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConstructionSite that = (ConstructionSite) o;
        return id.equals(that.id) &&
                Objects.equals(fullName, that.fullName) &&
                shortName.equals(that.shortName) &&
                Objects.equals(customerId, that.customerId) &&
                responsibleId.equals(that.responsibleId) &&
                Objects.equals(contractorId, that.contractorId) &&
                Objects.equals(dateOfStart, that.dateOfStart) &&
                Objects.equals(dateOfFinish, that.dateOfFinish);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, customerId, responsibleId, contractorId);
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
