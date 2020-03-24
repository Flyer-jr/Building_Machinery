package com.fly.repository.hibernate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "m_customers")
public class HibernateCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "adress")
    private String adress;

    @Column(name = "manager")
    private String managerName;

    @Column(name = "phone_number")
    private String phoneNumber;
}
