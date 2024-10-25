package com.encora.service;

import com.encora.common.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private RabbitTemplate rabbitTemplate;

    public Product createProduct(Product product) {
        return new Product();
    }

    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(1, "product 1", "description", 100.2),
                new Product(2, "product 2", "description", 2455.12)
        );
    }
}
