package com.shuja.library_management.security;

import com.shuja.library_management.model.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.shuja.library_management.exception.UsernameNotFoundException;
import com.shuja.library_management.model.User;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Username " + username + " not found"
                        ));

        return new CustomUserDetails(user);
    }

}
