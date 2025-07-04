package com.example.myapp.userservice.repository;

import com.example.myapp.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByNameAndOrganizationIsNull(); // global role
    Optional<Role> findByNameAndOrganization_Id(UUID orgId); // custom role
}
