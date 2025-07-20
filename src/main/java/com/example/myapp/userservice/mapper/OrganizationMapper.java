package com.example.myapp.userservice.mapper;

import com.example.myapp.userservice.dto.OrganizationCreateDTO;
import com.example.myapp.userservice.dto.OrganizationResponseDTO;
import com.example.myapp.userservice.model.Organization;

public class OrganizationMapper {

    public static Organization toEntity(OrganizationCreateDTO dto) {
        Organization org = new Organization();
        org.setName(dto.getName());
        return org;
    }

    public static OrganizationResponseDTO toDTO(Organization org) {
        return new OrganizationResponseDTO(
                org.getId(),
                org.getName(),
                org.getCreatedAt(),
                org.getUpdatedAt()
        );
    }
}
