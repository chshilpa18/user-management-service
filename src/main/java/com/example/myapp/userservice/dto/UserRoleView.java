package com.example.myapp.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserRoleView {
    private UUID roleId;
    private String roleName;
    private boolean isGlobal;
}