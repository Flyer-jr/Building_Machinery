package com.fly.repository.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "m_conflicts")
public class ConflictContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @Column(name = "source_order_id")
    Long sourceOrderId;

    @Column(name = "target_order_id")
    Long targetOrderId;

    @Column(name = "equipment_id")
    Long equipmentId;

    @Column(name = "operation_date")
    Date operationDate;



}
