package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fly.util.EntityIdResolver;
import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@Entity
@JsonIdentityInfo(
    property = "id",
    generator = ObjectIdGenerators.PropertyGenerator.class,
    scope = EquipmentProducer.class,
    resolver = EntityIdResolver.class)
@Table(name = "m_equipment_producers")
public class EquipmentProducer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "post_adress")
  private String postAddress;
}
