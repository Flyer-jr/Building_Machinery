package com.fly.repository.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "m_equipment")
public class HibernateEquipment {
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
    private HibernateEquipmentProducer producer;


}
