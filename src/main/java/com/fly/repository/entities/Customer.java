package com.fly.repository.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class Customer {
    private Long id;
    private String companyName;
    private String adress;
    private String managerName;
    private String phoneNumber;

    public Customer ( Long id, String companyName, String adress, String managerName, String phoneNumber ) {
        this.id = id;
        this.companyName = companyName;
        this.adress = adress;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                companyName.equals(customer.companyName) &&
                Objects.equals(adress, customer.adress) &&
                Objects.equals(managerName, customer.managerName) &&
                Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, phoneNumber);
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getCompanyName () {
        return companyName;
    }

    public void setCompanyName ( String companyName ) {
        this.companyName = companyName;
    }

    public String getAdress () {
        return adress;
    }

    public void setAdress ( String adress ) {
        this.adress = adress;
    }

    public String getManagerName () {
        return managerName;
    }

    public void setManagerName ( String managerName ) {
        this.managerName = managerName;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber ( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
