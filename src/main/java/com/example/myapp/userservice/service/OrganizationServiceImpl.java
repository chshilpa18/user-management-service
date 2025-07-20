package com.example.myapp.userservice.service;

import com.example.myapp.userservice.model.Organization;
import com.example.myapp.userservice.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    /**
     * @param org
     * @return
     */
    @Override
    public Organization createOrganization(Organization org) {
        return organizationRepository.save(org);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Organization> getOrganizationById(UUID id) {
        return Optional.of(organizationRepository.getById(id));
    }

    /**
     * @return
     */
    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }
}
