package com.example.myapp.userservice.repository;

import com.example.myapp.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByNameAndOrganizationIsNull(String name); // global role
    // 3. Alternative: Find role by name and organization ID using custom query
    @Query("SELECT r FROM Role r WHERE r.name = :name AND r.organization.id = :orgId")
    Optional<Role> findByNameAndOrganizationId(@Param("name") String name, @Param("orgId") UUID orgId);


    //This would check custom role first, then global fallback.
    Optional<Role> findByNameAndOrganization_IdOrOrganizationIsNull(String name, UUID orgId);

    default Optional<Role> findScopedRoleByName(String name, UUID orgId) {
        return findByNameAndOrganizationId(name, orgId)
                .or(() -> findByNameAndOrganizationIsNull(name));
    }

}
