package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "m_equipment")
public class Equipment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "store_number")
  private String storeNumber;

  @Column(name = "model")
  private String model;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "producer_id")
  @JsonIdentityReference(alwaysAsId = true)
  private EquipmentProducer producer;
}
