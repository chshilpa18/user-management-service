package com.example.myapp.userservice.service;

import com.example.myapp.userservice.dto.RegisterRequest;
import com.example.myapp.userservice.dto.UserResponse;
import com.example.myapp.userservice.model.*;
import com.example.myapp.userservice.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse registerUser(RegisterRequest request) {
        userRepository.findByEmail(request.getEmail()).ifPresent(u -> {
            throw new IllegalArgumentException("Email already in use");
        });

        Organization org = organizationRepository.findById(request.getOrganizationId())
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        User user = User.builder()
                .fullName(request.getName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .organization(org)
                .build();

        User savedUser = userRepository.save(user);

        Role defaultRole = roleRepository.findByNameAndOrganizationIsNull("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("Global default role not configured"));

        UserRole userRole = UserRole.builder()
                .user(savedUser)
                .role(defaultRole)
                .organization(org)
                .build();

        userRoleRepository.save(userRole);

        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getFullName())
                .email(savedUser.getEmail())
                .organizationId(org.getId())
                .build();
    }
}

