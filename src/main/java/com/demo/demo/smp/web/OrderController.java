package com.demo.demo.smp.web;

import com.demo.demo.smp.dto.OrderDTO;
import com.demo.demo.smp.dto.OrderRequest;
import com.demo.demo.smp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderDTO placeOrder(@RequestBody OrderRequest request) {
        return orderService.placeOrder(request);
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderDTO> getCustomerOrders(@PathVariable Long customerId) {
        return orderService.getCustomerOrders(customerId);
    }
}
