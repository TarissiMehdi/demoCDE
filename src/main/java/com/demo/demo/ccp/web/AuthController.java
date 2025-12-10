package com.demo.demo.ccp.web;

import com.demo.demo.ccp.dto.CustomerDTO;
import com.demo.demo.ccp.dto.LoginRequest;
import com.demo.demo.ccp.dto.RegisterRequest;
import com.demo.demo.ccp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public CustomerDTO login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public CustomerDTO register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}
