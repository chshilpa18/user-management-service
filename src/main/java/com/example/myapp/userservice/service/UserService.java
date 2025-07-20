package com.example.myapp.userservice.service;

import com.example.myapp.userservice.dto.RegisterRequest;
import com.example.myapp.userservice.dto.UserResponse;

public interface UserService {
    public UserResponse registerUser(RegisterRequest request);
}
