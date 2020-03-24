package com.fly.repository.hibernate;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@RequiredArgsConstructor
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


    @Column(name = "date_taken")
    private Date dateTaken;


}
