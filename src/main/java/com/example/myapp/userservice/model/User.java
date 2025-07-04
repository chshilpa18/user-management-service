package com.example.myapp.userservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Email  // <-- VALIDATION ADDED
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone")  // <-- OPTIONAL FIELD
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public enum Status {
        ACTIVE,
        DISABLED,
        DELETED
    }

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        if (status == null) {
            status = Status.ACTIVE;
        }
    }

    /**
     *  So when would you add @OneToMany + @JsonIgnore?
     *  Add it only if you plan to:
     *
     * Expose a user’s roles inside the user object in a REST response
     * Navigate from User → UserRole directly (and need it preloaded or returned)
     */
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<UserRole> userRoles = new ArrayList<>();

}
