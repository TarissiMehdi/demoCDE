package com.demo.demo.smp.service.impl;

import com.demo.demo.ccp.entity.Customer;
import com.demo.demo.ccp.repository.CustomerRepository;
import com.demo.demo.smp.dto.OrderDTO;
import com.demo.demo.smp.dto.OrderRequest;
import com.demo.demo.smp.entity.Order;
import com.demo.demo.smp.entity.OrderItem;
import com.demo.demo.smp.entity.Product;
import com.demo.demo.smp.repository.OrderRepository;
import com.demo.demo.smp.repository.ProductRepository;
import com.demo.demo.smp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Override
    public OrderDTO placeOrder(OrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus("COMPLETED");

        List<OrderItem> items = new ArrayList<>();
        double totalAmount = 0.0;

        for (var itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());

            items.add(orderItem);
            totalAmount += product.getPrice() * itemRequest.getQuantity();
        }

        order.setItems(items);
        order.setTotalAmount(totalAmount);

        Order savedOrder = orderRepository.save(order);

        return mapToDTO(savedOrder);
    }

    @Override
    public List<OrderDTO> getCustomerOrders(Long customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO mapToDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .build();
    }
}
