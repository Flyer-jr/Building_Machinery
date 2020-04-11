package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fly.util.EntityIdResolver;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Equipment.class,
        resolver = EntityIdResolver.class)
@Table(name = "m_equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "store_number")
    private Long storeNumber;

    @Column(name = "model")
    private String model;

    @Column(name = "is_taken")
    private boolean isTaken;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "producer_id")
    @JsonIdentityReference(alwaysAsId = true)
    private EquipmentProducer producer;


}
