package com.demo.demo.smp.service;

import com.demo.demo.smp.dto.OrderDTO;
import com.demo.demo.smp.dto.OrderRequest;
import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(OrderRequest request);

    List<OrderDTO> getCustomerOrders(Long customerId);
}
