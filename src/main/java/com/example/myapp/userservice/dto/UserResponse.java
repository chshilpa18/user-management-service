package com.example.myapp.userservice.dto;


import lombok.Builder;

import java.util.UUID;

@Builder
public class UserResponse {

    private UUID id;
    private String name;
    private String email;
    private UUID organizationId;

    // Getters and setters

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UUID getOrganizationId() { return organizationId; }
    public void setOrganizationId(UUID organizationId) { this.organizationId = organizationId; }
}