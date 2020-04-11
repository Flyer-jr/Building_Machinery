package com.fly.repository.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fly.util.EntityIdResolver;
import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@EqualsAndHashCode
@Entity@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class,
        scope = Contractor.class,
        resolver = EntityIdResolver.class)

@Table(name = "m_contractor")
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "adress")
    private String address;
}
