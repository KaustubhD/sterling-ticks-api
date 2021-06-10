package org.ibm.sterling_ticks.security.authentication;

import org.ibm.sterling_ticks.model.enitities.UserModel;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

  public UserDetails toUserDetails(UserModel user) {

    return User.withUsername(user.getUserName())
        .password(user.getPassword())
        .build();
  }
}
