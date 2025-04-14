package com.soultech.productmanagement.services;

import com.soultech.productmanagement.model.User_Profile;
import com.soultech.productmanagement.model.Users;
import com.soultech.productmanagement.repositories.RegistrationRepository;
import com.soultech.productmanagement.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling user registration logic,
 * including saving user credentials securely and persisting the user profile.
 *
 * @author Solomon Demisse
 */
@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(RegistrationRepository registrationRepository,
                               UserRepository userRepository,
                               PasswordEncoder passwordEncoder) {
        this.registrationRepository = registrationRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Adds a new user profile to the system. It securely encodes the user's password,
     * saves the user entity, and then persists the associated user profile.
     *
     * @param userProfile The user profile containing user details to be registered.
     */
    public void addUserProfile(User_Profile userProfile) {
        Users user = userProfile.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        registrationRepository.save(userProfile);
    }
}
