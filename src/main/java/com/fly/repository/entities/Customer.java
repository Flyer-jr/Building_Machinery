package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fly.util.EntityIdResolver;
import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Customer.class,
        resolver = EntityIdResolver.class)
@Table(name = "m_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "adress")
    private String address;

    @Column(name = "manager")
    private String managerName;

    @Column(name = "phone_number")
    private String phoneNumber;
}
