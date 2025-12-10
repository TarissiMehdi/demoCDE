package com.demo.demo.smp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
}
