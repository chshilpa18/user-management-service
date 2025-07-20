package com.example.myapp.userservice.service;

import com.example.myapp.userservice.model.Organization;

@FunctionalInterface
public interface OrganizationValidator {
    boolean isValid(Organization org);
}