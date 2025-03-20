package com.soultech.productmanagement.repositories;

import com.soultech.productmanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for interacting with the User entity in the database.
 * * @author Solomon Demisse
 *  * @version 1.0
 *  * @since 2025-03-20
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    /**
     * Finds a user by their username.
     * @param username the username to search for
     * @return an Optional containing the User if found, or empty if not
     */
    Optional<Users> findByUsername(String username);
}
