package com.demo.demo.smp.entity;

import com.demo.demo.ccp.entity.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "customer_order") // 'Order' is a reserved keyword in some SQL dialects
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private Double totalAmount;
    private String status; // PENDING, COMPLETED, CANCELLED
}
