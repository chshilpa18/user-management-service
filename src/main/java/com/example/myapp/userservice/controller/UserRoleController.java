package com.example.myapp.userservice.controller;

import com.example.myapp.userservice.dto.AssignRoleRequest;
import com.example.myapp.userservice.dto.UserRoleView;
import com.example.myapp.userservice.service.UserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping("/assign")
    public ResponseEntity<Void> assignRole(@RequestBody @Valid AssignRoleRequest request) {
        userRoleService.assignRoleToUser(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserRoleView>> getUserRoles (
            @PathVariable UUID userId,
            @RequestParam UUID orgId) {
        List<UserRoleView> roles = userRoleService.getUserRolesInOrg(userId, orgId);
        return ResponseEntity.ok(roles);
    }
}