package com.aitu.ecommerce.builder;

import com.aitu.ecommerce.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderBuilder {
    private String customerName;
    private final List<OrderItem> items = new ArrayList<>();

    public OrderBuilder setCustomerName(String name) {
        this.customerName = name;
        return this;
    }

    public OrderBuilder addProduct(
            Product product,
            int quantity
    ) {
        items.add(new OrderItem(product, quantity));
        return this;
    }

    public Order build() {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalStateException(
                    "Customer name is required"
            );
        }

        if (items.isEmpty()) {
            throw new IllegalStateException(
                    "Order must contain at least one product"
            );
        }

        return new Order(
                UUID.randomUUID().toString().substring(0, 8),
                customerName,
                items
        );
    }
}