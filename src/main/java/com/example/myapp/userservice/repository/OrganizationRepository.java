package com.example.myapp.userservice.repository;

import com.example.myapp.userservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    Optional<Organization> findByName(String name);
}