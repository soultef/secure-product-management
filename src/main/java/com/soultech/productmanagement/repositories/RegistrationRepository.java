package com.soultech.productmanagement.repositories;

import com.soultech.productmanagement.model.User_Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User_Profile, Long> {
}
