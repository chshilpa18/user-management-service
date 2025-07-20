package com.example.myapp.userservice.controller;

import com.example.myapp.userservice.dto.OrganizationCreateDTO;
import com.example.myapp.userservice.dto.OrganizationResponseDTO;
import com.example.myapp.userservice.mapper.OrganizationMapper;
import com.example.myapp.userservice.model.Organization;
import com.example.myapp.userservice.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    @PostMapping
    public ResponseEntity<OrganizationResponseDTO> createOrganization(@Valid @RequestBody OrganizationCreateDTO dto) {
        Organization org = OrganizationMapper.toEntity(dto);
        Organization saved = organizationService.createOrganization(org);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrganizationMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponseDTO> getOrg(@PathVariable UUID id) {
        return organizationService.getOrganizationById(id)
                .map(org -> ResponseEntity.ok(OrganizationMapper.toDTO(org)))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public List<OrganizationResponseDTO> getAllOrganizations(){
        return organizationService.getAllOrganizations()
                .stream()
                .map(OrganizationMapper::toDTO)
                .toList();
    }
}
