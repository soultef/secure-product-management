package com.soultech.productmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


/**
 * Represents a user in the product management application.
 * A user has an ID, username, password, and role.
 * This class serves as a model for authenticate user.
 *
 * @author Solomon Demisse
 * @version 1.0
 * @since 2025-03-20
 */
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required")
    private String username;
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{id=" + id + ", username='" + username + "', role='" + role + "'}";
    }
}
