package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fly.util.EntityIdResolver;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;


@RequiredArgsConstructor
@Data
@EqualsAndHashCode
@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = ConstructionSite.class,
        resolver = EntityIdResolver.class)
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

  @Column
  private String login;

  @Column
  private String password;

  private String email;

  @Column
  private String post;

  @Column(name = "actual")
  private boolean isActual;

  @Column(name = "date_of_dissmiss")
  private Timestamp dateOfDismiss;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role")
  @JsonIgnore
  private Role role;
}
