package com.demo.demo.ccp.web;

import com.demo.demo.ccp.dto.CustomerDTO;
import com.demo.demo.ccp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/allyy")
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    @PostMapping
    public CustomerDTO create(@RequestBody CustomerDTO customerDTO) {
        return customerService.create(customerDTO);
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public CustomerDTO update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.update(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }

}