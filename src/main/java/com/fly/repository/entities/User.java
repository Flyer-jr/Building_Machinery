package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fly.util.EntityIdResolver;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

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
  private String password;

  @Column
  private String post;

  @Column(name = "actual")
  private boolean isActual;

  @Column(name = "date_of_dissmiss")
  private Date dateOfDismiss;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role")
  @JsonIgnore
  private Role role;

//  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//  @JsonBackReference
//  private List<Order> userOrders = new ArrayList<>();
}
