package com.fly.repository.dao;

import com.fly.repository.entities.NotConfirmedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotConfirmedUsersRepository
        extends JpaRepository<NotConfirmedUser, Long>, CrudRepository<NotConfirmedUser, Long> {

    NotConfirmedUser findNotConfirmedUserByConfirmationToken(String token);

    Optional<NotConfirmedUser> findNotConfirmedUserByEmail(String email);

    Optional<NotConfirmedUser> findNotConfirmedUserByLogin(String login);
}
