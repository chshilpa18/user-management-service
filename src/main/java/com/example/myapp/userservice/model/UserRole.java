package com.example.myapp.userservice.model;

import com.example.myapp.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

/*
All IDs are UUIDs.
Role.organization is nullable → null means global role.
UserRole ties a User to a Role within an Organization.
Unique constraints prevent duplicates.
* */
@Entity
@Table(
        name = "user_roles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "org_id", "role_id"}),
        indexes = {
                @Index(name = "idx_user_org", columnList = "user_id, org_id"),
                @Index(name = "idx_role_org", columnList = "role_id, org_id")
        }
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "assigned_at", nullable = false, updatable = false)
    private Instant assignedAt;

    @PrePersist
    protected void onAssign() {
        assignedAt = Instant.now();
    }
}
