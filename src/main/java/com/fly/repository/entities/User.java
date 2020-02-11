package com.fly.repository.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;
import java.util.Objects;

public class User {
        private Long id;
        private String firstName;
        private String secondName;
        private String phoneNumber;
        private String password;
        private String post;
        private boolean isActual;
        private Date dateOfDismiss;

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getSecondName () {
        return secondName;
    }

    public void setSecondName ( String secondName ) {
        this.secondName = secondName;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber ( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getPost () {
        return post;
    }

    public void setPost ( String post ) {
        this.post = post;
    }

    public boolean isActual () {
        return isActual;
    }

    public void setActual ( boolean actual ) {
        isActual = actual;
    }

    public Date getDateOfDismiss () {
        return dateOfDismiss;
    }

    public void setDateOfDismiss ( Date dateOfDismiss ) {
        this.dateOfDismiss = dateOfDismiss;
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActual == user.isActual &&
                id.equals(user.id) &&
                firstName.equals(user.firstName) &&
                secondName.equals(user.secondName) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(password, user.password) &&
                Objects.equals(post, user.post) &&
                Objects.equals(dateOfDismiss, user.dateOfDismiss);
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, firstName, secondName, phoneNumber, password, post, isActual, dateOfDismiss);
    }
}
