package com.fly.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class Equipment {
    private Long id;
    private Long storeNumber;
    private String model;
    private boolean isTaken;
    private Long producerId;

    public Equipment ( Long id, Long storeNumber, String model, boolean isTaken, Long producerId ) {
        this.id = id;
        this.storeNumber = storeNumber;
        this.model = model;
        this.isTaken = isTaken;
        this.producerId = producerId;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public Long getStoreNumber () {
        return storeNumber;
    }

    public void setStoreNumber ( Long storeNumber ) {
        this.storeNumber = storeNumber;
    }

    public String getModel () {
        return model;
    }

    public void setModel ( String model ) {
        this.model = model;
    }

    public boolean isTaken () {
        return isTaken;
    }

    public void setTaken ( boolean taken ) {
        isTaken = taken;
    }

    public Long getProducerId () {
        return producerId;
    }

    public void setProducerId ( Long producerId ) {
        this.producerId = producerId;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return isTaken == equipment.isTaken &&
                id.equals(equipment.id) &&
                storeNumber.equals(equipment.storeNumber) &&
                Objects.equals(model, equipment.model) &&
                Objects.equals(producerId, equipment.producerId);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, storeNumber);
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
