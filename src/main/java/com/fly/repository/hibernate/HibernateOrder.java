package com.fly.repository.hibernate;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "m_order_equipment",
            joinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
    private Set<HibernateEquipment> orderEquipment;



    @Column(name = "date_taken")
    private Date dateTaken;


}
