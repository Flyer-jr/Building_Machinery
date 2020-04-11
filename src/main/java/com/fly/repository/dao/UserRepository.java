package com.fly.repository.dao;

import com.fly.repository.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

  Optional<User> findUserByPhoneNumber(String phoneNumber);
  User findUserByFirstName(String firstName);
  User findUserBySecondName(String secondName);
  List<User> findUsersByFirstName(String firstName);


  }
