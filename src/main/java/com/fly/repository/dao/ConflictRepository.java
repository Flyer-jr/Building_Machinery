package com.fly.repository.dao;

import com.fly.repository.entities.conflict.ConflictWriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConflictRepository extends JpaRepository<ConflictWriter, Long>,
        CrudRepository<ConflictWriter, Long> {

    List<ConflictWriter> findAllByTargetOrderId(Long id);
}
