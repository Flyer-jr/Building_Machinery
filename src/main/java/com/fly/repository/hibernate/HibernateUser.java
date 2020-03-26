package com.fly.repository.hibernate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id", "password", "post", "isActual", "dateOfDismiss"})
@Entity
@Table(name = "m_user")
public class HibernateUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "post")
    private String post;

    @Column(name = "actual")
    private boolean isActual;

    @Column(name = "date_of_dissmiss")
    private Date dateOfDismiss;

}
