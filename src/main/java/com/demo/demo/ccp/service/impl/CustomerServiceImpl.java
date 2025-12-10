package com.demo.demo.ccp.service.impl;

import com.demo.demo.ccp.dto.CustomerDTO;
import com.demo.demo.ccp.entity.Customer;
import com.demo.demo.ccp.repository.CustomerRepository;
import com.demo.demo.ccp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAllCustomers().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToDTO(customer);
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = mapToEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return mapToDTO(savedCustomer);
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        existingCustomer.setName(customerDTO.getName());
        existingCustomer.setEmail(customerDTO.getEmail());
        existingCustomer.setRole(customerDTO.getRole());
        // Address and Password updates should ideally be separate or handled carefully
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return mapToDTO(updatedCustomer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .role(customer.getRole())
                .build();
    }

    private Customer mapToEntity(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .role(customerDTO.getRole())
                .build();
    }
}
