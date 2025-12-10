package com.demo.demo.ccp.service;

import com.demo.demo.ccp.dto.CustomerDTO;
import com.demo.demo.ccp.dto.LoginRequest;
import com.demo.demo.ccp.dto.RegisterRequest;

public interface AuthService {
    CustomerDTO login(LoginRequest request);

    CustomerDTO register(RegisterRequest request);
}
