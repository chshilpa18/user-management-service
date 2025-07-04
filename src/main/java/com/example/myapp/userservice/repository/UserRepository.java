package com.example.myapp.userservice.repository;

import com.example.myapp.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository // Needed only if you're customizing behavior (optional otherwise)
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}

/**
 * We didn’t add @Transactional here — Spring handles that in service layer.
 * We didn’t add @Query because default is enough for now.
 */