package com.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

        public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class, args);
        }

        @org.springframework.context.annotation.Bean
        org.springframework.boot.CommandLineRunner runner(com.demo.demo.smp.repository.ProductRepository repository) {
                return args -> {
                        if (repository.count() == 0) {
                                repository.save(com.demo.demo.smp.entity.Product.builder()
                                                .name("Premium Noise-Cancelling Headphones")
                                                .price(349.99)
                                                .description("Experience silence with our top-tier noise cancelling technology.")
                                                .imageUrl(
                                                                "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=500&auto=format&fit=crop&q=60")
                                                .build());
                                repository.save(com.demo.demo.smp.entity.Product.builder()
                                                .name("Ultra-Slim 4K Monitor")
                                                .price(499.50)
                                                .description("Crystal clear 4K resolution in an ultra-slim profile.")
                                                .imageUrl(
                                                                "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=500&auto=format&fit=crop&q=60")
                                                .build());
                                repository.save(com.demo.demo.smp.entity.Product.builder()
                                                .name("Wireless Mechanical Keyboard")
                                                .price(129.00)
                                                .description("Tactile feedback without the wires. Perfect for gaming and typing.")
                                                .imageUrl(
                                                                "https://images.unsplash.com/photo-1511467687858-23d96c32e4ae?w=500&auto=format&fit=crop&q=60")
                                                .build());
                                repository.save(com.demo.demo.smp.entity.Product.builder()
                                                .name("Ergonomic Gaming Mouse")
                                                .price(79.99)
                                                .description("Precision tracking and ergonomic design for long gaming sessions.")
                                                .imageUrl(
                                                                "https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?w=500&auto=format&fit=crop&q=60")
                                                .build());
                        }
                };
        }

}
