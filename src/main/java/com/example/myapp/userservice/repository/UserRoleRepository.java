package com.example.myapp.userservice.repository;

import com.example.myapp.userservice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    List<UserRole> findByUser_IdAndOrganization_Id(UUID userId, UUID orgId);
}
