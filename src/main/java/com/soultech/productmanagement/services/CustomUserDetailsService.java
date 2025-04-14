package com.soultech.productmanagement.services;

import com.soultech.productmanagement.model.Users;
import com.soultech.productmanagement.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomUserDetailsService is a custom implementation of Spring Security's UserDetailsService.
 * It is responsible for retrieving user information from the database during the authentication process.
 *
 * <p>This service fetches the user by username and constructs a UserDetails object
 * with roles formatted to Spring Security's required authority format (e.g., ROLE_ADMIN).</p>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    /**
     * Constructs the service with the required UserRepository.
     *
     * @param userRepository the repository used to retrieve user data from the database
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads a user by their username and builds a Spring Security UserDetails object.
     *
     * @param username the username of the user to retrieve
     * @return the UserDetails instance containing the user's credentials and authorities
     * @throws UsernameNotFoundException if the user is not found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
