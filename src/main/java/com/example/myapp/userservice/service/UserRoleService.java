package com.example.myapp.userservice.service;

import com.example.myapp.userservice.dto.AssignRoleRequest;
import com.example.myapp.userservice.dto.UserRoleView;
import com.example.myapp.userservice.model.*;
import com.example.myapp.userservice.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRoleRepository userRoleRepository;

    @Transactional
    public void assignRoleToUser(AssignRoleRequest request) {
        boolean exists = userRoleRepository
                .findByUser_IdAndRole_IdAndOrganization_Id(
                        request.getUserId(),
                        request.getRoleId(),
                        request.getOrganizationId()
                )
                .isPresent();

        if (exists) {
            throw new IllegalArgumentException("User already has this role in the organization.");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));

        Organization org = organizationRepository.findById(request.getOrganizationId())
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        UserRole userRole = UserRole.builder()
                .user(user)
                .role(role)
                .organization(org)
                .build();

        userRoleRepository.save(userRole);
    }

    public List<UserRoleView> getUserRolesInOrg(UUID userId, UUID orgId) {
        return userRoleRepository.findByUser_IdAndOrganization_Id(userId, orgId).stream()
                .map(ur -> new UserRoleView(
                        ur.getRole().getId(),
                        ur.getRole().getName(),
                        ur.getRole().getOrganization() == null
                ))
                .toList();
    }
}