package com.demo.demo.smp.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    private Long id;
    private Double totalAmount;
    private String status;
    // Simplified for demo, could include items
}
