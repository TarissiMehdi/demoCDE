package com.demo.demo.smp.service;

import com.demo.demo.smp.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    ProductDTO create(ProductDTO productDTO);

    ProductDTO update(Long id, ProductDTO productDTO);

    void delete(Long id);
}
