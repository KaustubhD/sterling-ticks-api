package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.security.authentication.UserDetailsMapper;
import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

	@Autowired
  private UserRepository userRepository;
	@Autowired
  private  UserDetailsMapper userDetailsMapper;


  @Override
  public UserDetails loadUserByUsername(String username) 
                         throws UsernameNotFoundException {
    UserModel user =
                    userRepository.findByUserName(username);
    return userDetailsMapper.toUserDetails(user);
  }
}