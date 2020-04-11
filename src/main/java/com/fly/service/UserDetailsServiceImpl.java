package com.fly.service;

import com.fly.repository.dao.RoleRepository;
import com.fly.repository.dao.UserRepository;
import com.fly.repository.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException {
    try {
      Optional<User> result = userRepository.findUserByPhoneNumber(phonenumber);
      if (result.isPresent()) {
        User user = result.get();
        return new org.springframework.security.core.userdetails.User(
            user.getPhoneNumber(),
            user.getPassword(),
            AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole().getRoleName()));

      } else {
        throw new UsernameNotFoundException(
            String.format("No user found with login '%s'.", phonenumber));
      }
    } catch (Exception e) {
      throw new UsernameNotFoundException("User with this login not found");
    }
  }
}
