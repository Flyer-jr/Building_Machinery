package com.fly.classes;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;
import java.util.Objects;

public class Order {
    private Long id;
    private Long userId;
    private Long constructionSiteId;
    private Date dateTaken;

    public Order ( Long id, Long userId, Long constructionSiteId, Date dateTaken ) {
        this.id = id;
        this.userId = userId;
        this.constructionSiteId = constructionSiteId;
        this.dateTaken = dateTaken;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId ( Long userId ) {
        this.userId = userId;
    }

    public Long getConstructionSiteId () {
        return constructionSiteId;
    }

    public void setConstructionSiteId ( Long constructionSiteId ) {
        this.constructionSiteId = constructionSiteId;
    }

    public Date getDateTaken () {
        return dateTaken;
    }

    public void setDateTaken ( Date dateTaken ) {
        this.dateTaken = dateTaken;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                userId.equals(order.userId) &&
                constructionSiteId.equals(order.constructionSiteId) &&
                Objects.equals(dateTaken, order.dateTaken);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, userId, constructionSiteId);
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
