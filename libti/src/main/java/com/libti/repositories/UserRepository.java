package com.libti.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libti.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    
    Optional<UserModel> findByEmail(String email);
}
