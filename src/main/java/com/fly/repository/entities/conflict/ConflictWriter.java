package com.fly.repository.entities.conflict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "m_conflicts")
public class ConflictWriter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "target_order_id")
    Long targetOrderId;

    @Column(name = "source_order_id")
    Long sourceOrderId;

    @Column(name = "equipment_id")
    Long equipmentId;

    @Column(name = "operation_date")
    Date operationDate;


}
