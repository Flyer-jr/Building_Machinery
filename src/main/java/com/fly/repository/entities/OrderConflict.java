package com.fly.repository.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collections;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "m_order_conflicts")
public class OrderConflict {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @JsonBackReference
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "source_order_id")
        private Order sourceOrder;

        @JsonBackReference
        @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
        @JoinColumn(name = "target_order_id")
        private Order targetOrder;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "m_order_conflicts_equipment",
                joinColumns = @JoinColumn(name = "order_conflict_id"),
                inverseJoinColumns = @JoinColumn(name = "equipment_id"))
        private Set<Equipment> equipment = Collections.emptySet();

        @Override
        public String toString() {
                return "Order Conflict took place while creating: \n" +
                        "Order №: " + targetOrder.getId() + "\n" +
                        "Source Order № " + sourceOrder.getId() + "\n" +
                        "equipment taken:  " + equipment.stream().toString();
        }
}
