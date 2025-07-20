package com.example.myapp.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationResponseDTO {
    private UUID id;
    private String name;
    private Instant createdAt;
    private Instant updatedAt;

}
