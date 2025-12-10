package com.demo.demo.ccp.service.impl;

import com.demo.demo.ccp.dto.CustomerDTO;
import com.demo.demo.ccp.dto.LoginRequest;
import com.demo.demo.ccp.dto.RegisterRequest;
import com.demo.demo.ccp.entity.Customer;
import com.demo.demo.ccp.repository.CustomerRepository;
import com.demo.demo.ccp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO login(LoginRequest request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!customer.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return mapToDTO(customer);
    }

    @Override
    public CustomerDTO register(RegisterRequest request) {
        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Customer customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword()) // In real app, hash this!
                .address(request.getAddress())
                .role("CUSTOMER")
                .build();

        Customer saved = customerRepository.save(customer);
        return mapToDTO(saved);
    }

    private CustomerDTO mapToDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .role(customer.getRole())
                .build();
    }
}
