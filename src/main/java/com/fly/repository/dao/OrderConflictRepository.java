package com.fly.repository.dao;

import com.fly.repository.entities.OrderConflict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderConflictRepository extends CrudRepository<OrderConflict, Long>, JpaRepository<OrderConflict, Long> {

    List<OrderConflict> findOrderConflictsByTargetOrderId(Long id);

}
