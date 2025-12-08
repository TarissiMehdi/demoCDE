package com.demo.demo.ccp.repository;

import com.demo.demo.ccp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //query to select all customers
    @Query("SELECT c FROM Customer c")
    List<Customer> findAllCustomers();
}
