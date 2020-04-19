package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fly.util.EntityIdResolver;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@RequiredArgsConstructor
@Data
@Entity
@JsonIdentityInfo(
    property = "id",
    generator = ObjectIdGenerators.PropertyGenerator.class,
    scope = ConstructionSite.class,
    resolver = EntityIdResolver.class)
@Table(name = "m_construction_site")
public class ConstructionSite {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "short_name")
  private String shortName;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "customer_id")
  @JsonIdentityReference(alwaysAsId = true)
  private Customer customer;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "responsible_id")
  @JsonIdentityReference(alwaysAsId = true)
  private User responsible;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "contractor_id")
  @JsonIdentityReference(alwaysAsId = true)
  private Contractor contractor;

  @Column(name = "date_of_start")
  private Timestamp dateOfStart;

  @Column(name = "date_of_finish")
  private Timestamp dateOfFinish;
}
