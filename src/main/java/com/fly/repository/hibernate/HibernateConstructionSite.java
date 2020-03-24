package com.fly.repository.hibernate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "m_construction_site")
public class HibernateConstructionSite {
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
    private HibernateCustomer customer;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "responsible_id")
    private HibernateUser responsible;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contractor_id")
    private HibernateContractor contractor;


    @Column(name = "date_of_start")
    private Date dateOfStart;


    @Column(name = "date_of_finish")
    private Date dateOfFinish;

}
