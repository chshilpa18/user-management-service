package com.example.myapp.userservice.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

//Dont need to use this because we have unique constraint on UserRole table which is better because
// it make querying complex to use composite keys
@Embeddable
public class UserRoleId implements Serializable {

    private Long userId;
    private Long roleId;

    public UserRoleId() {}

    public UserRoleId(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    // Getters and setters

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }

    // equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId)) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }
}
