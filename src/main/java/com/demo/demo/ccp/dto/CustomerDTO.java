package com.demo.demo.ccp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String role;
    // Password is intentionally omitted from DTO to avoid exposing it
}
