package com.fly.repository.dao;

import com.fly.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

  Optional<User> findUserByLogin(String login);

  User findUserBySecondName(String secondName);

  Optional<User> findUserByEmail(String eMail);
}
