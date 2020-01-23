package com.fly.classes;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class Contractor {
    private Long id;
    private String shortName;
    private String fullName;
    private String adress;

    public Contractor ( Long id, String shortName, String fullName, String adress ) {
        this.id = id;
        this.shortName = shortName;
        this.fullName = fullName;
        this.adress = adress;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getShortName () {
        return shortName;
    }

    public void setShortName ( String shortName ) {
        this.shortName = shortName;
    }

    public String getFullName () {
        return fullName;
    }

    public void setFullName ( String fullName ) {
        this.fullName = fullName;
    }

    public String getAdress () {
        return adress;
    }

    public void setAdress ( String adress ) {
        this.adress = adress;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contractor that = (Contractor) o;
        return id.equals(that.id) &&
                shortName.equals(that.shortName) &&
                Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, shortName, fullName);
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
