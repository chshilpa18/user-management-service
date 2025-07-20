package com.example.myapp.userservice.service;

import com.example.myapp.userservice.model.Organization;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationService {
    public Organization createOrganization(Organization org);
    public Optional<Organization> getOrganizationById(UUID id);
    public List<Organization> getAllOrganizations();

    // Default method example
    public default boolean organizationExists(UUID id) {
        return getOrganizationById(id).isPresent();
    }
    // Static helper method example
    public static void log( String message){
        System.out.println("[OrganizationService] " + message);

    }
}
