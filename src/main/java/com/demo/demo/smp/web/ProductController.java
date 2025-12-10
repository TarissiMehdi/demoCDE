package com.demo.demo.smp.web;

import com.demo.demo.smp.dto.ProductDTO;
import com.demo.demo.smp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/all")
    public List<ProductDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return service.create(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return service.update(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}