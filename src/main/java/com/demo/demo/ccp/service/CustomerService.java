package com.demo.demo.ccp.service;

import com.demo.demo.ccp.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);

    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO update(Long id, CustomerDTO customerDTO);

    void delete(Long id);
}
