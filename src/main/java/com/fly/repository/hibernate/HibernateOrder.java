package com.fly.repository.hibernate;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id", "user_id", "construction_site_id", ""})
@Entity
@Table(name = "m_order")
public class HibernateOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private HibernateUser user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "construction_site_id")
    private HibernateConstructionSite constructionSite;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "m_order_equipment",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<HibernateEquipment> orderEquipment = new ArrayList<>();



    @Column(name = "date_taken")
    private Date dateTaken;


}
