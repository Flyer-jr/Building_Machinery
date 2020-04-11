package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(exclude = {"id", "user_id", "construction_site_id", ""})
@Entity
@Table(name = "m_order")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  @JsonIdentityReference(alwaysAsId = true)
  private User user;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "construction_site_id")
  @JsonIdentityReference(alwaysAsId = true)
  private ConstructionSite constructionSite;

  @Column(name = "date_taken")
  @Temporal(TemporalType.DATE)
  private Date dateTaken;

  @Column(name = "active")
  private boolean active;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "m_order_equipment",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "equipment_id"))
  private Set<Equipment> equipment = new HashSet<>();
}
