package com.example.myapp.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass // Used on abstract base classes that are not entities by themselves,
// but their fields should be inherited by child entities.
@EntityListeners(AuditingEntityListener.class) //ooks into the JPA lifecycle to populate auditing fields automatically.
//Needs Spring Data JPA Auditing enabled (@EnableJpaAuditing).
@Getter
@Setter
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "created_at" , nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt;

}
