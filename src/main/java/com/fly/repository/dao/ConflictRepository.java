package com.fly.repository.dao;

import com.fly.repository.entities.ConflictContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConflictRepository extends JpaRepository<ConflictContainer, Long>,
        CrudRepository<ConflictContainer, Long> {
}
