package com.fly.repository.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "m_user")
public class User {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "userIdSeq", sequenceName = "m_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
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
