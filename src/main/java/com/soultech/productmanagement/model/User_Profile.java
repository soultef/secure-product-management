package com.soultech.productmanagement.model;

import jakarta.persistence.*;

/**
 * Represents the profile of a user in the product management application.
 * This entity stores user-related information such as first name, last name,and email.
 * Each profile is associated with a specific user entity via a one-to-one relationship.
 * @author  Solomon Demisse
 * @version 001
 * @since 3/28/25
 */
@Entity
public class User_Profile {

    /**
     * Unique identifier for the user profile.
     * This ID is automatically generated using the strategy GenerationType.IDENTITY.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * First name of the user.
     * This field is used to store the user's first name.
     */
    private String firstName;

    /**
     * Last name of the user.
     * This field is used to store the user's last name.
     */
    private String lastName;

    /**
     * email of the user.
     * This field is used to store the user's email address.
     */
    private String email;



    /**
     * Role of the user within the application.
     * This field indicates the role assigned to the user (e.g., admin, user).
     */
    private String role;

    /**
     * One-to-one association between a user profile and a user entity.
     * The user_id column is used to link the profile to the corresponding user.
     * This field cannot be null, ensuring every profile is associated with a valid user.
     */
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    /**
     * Gets the unique identifier of the user profile.
     * @return the ID of the user profile.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user profile.
     * @param id the ID of the user profile to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the user.
     * @return the first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     * @param firstName the first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     * @return the last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     * @param lastName the last name to set.
     */
    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the user.
     * @return the email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * @param email the email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the associated user for this profile.
     * @return the user associated with this profile.
     */
    public Users getUser() {
        return user;
    }

    /**
     * Set the users ref variable
     * @param user user ref variable
     */
    public void setUser(Users user) {
        this.user = user;
    }


}


