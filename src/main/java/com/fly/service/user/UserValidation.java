package com.fly.service.user;

import com.fly.repository.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidation {

    private final UserRepository userRepository;

    public boolean userValid(String userName) {
        if (userRepository.findUserByFirstName(userName) != null ||
                userRepository.findUserBySecondName(userName) != null) return Boolean.TRUE;
        else {
            throw new UsernameNotFoundException(
                String.format("No user found with field '%s'.", userName));
                }


    }

}
