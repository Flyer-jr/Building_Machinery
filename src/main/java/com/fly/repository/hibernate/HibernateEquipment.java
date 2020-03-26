package com.fly.repository.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
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

//    @JsonBackReference
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order_id")
//    private List<HibernateOrder> equipmentOrder = new ArrayList<>();
}
