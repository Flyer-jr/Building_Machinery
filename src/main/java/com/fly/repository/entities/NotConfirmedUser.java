package com.fly.repository.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@RequiredArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "m_not_confirmed_users")
public class NotConfirmedUser {

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

  @Column
  private String login;

  @Column
  private String password;

  @Column
  private String email;

  @Column
  private String post;

  @Column(name = "confirmation_token")
  private String confirmationToken;
}
