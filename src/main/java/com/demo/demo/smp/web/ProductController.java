package com.demo.demo.smp.web;

import com.demo.demo.ccp.entity.Customer;
import com.demo.demo.ccp.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final CustomerRepository repo;

    public ProductController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Customer> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Customer create(@RequestBody Customer product) {
        return repo.save(product);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer product) {
        product.setId(id);
        return repo.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}