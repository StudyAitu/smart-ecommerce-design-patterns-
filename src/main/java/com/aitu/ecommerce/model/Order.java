package com.aitu.ecommerce.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final String orderId;
    private final String customerName;
    private final List<OrderItem> items;
    private String status;

    public Order(
            String orderId,
            String customerName,
            List<OrderItem> items
    ) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>(items);
        this.status = "CREATED";
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    public void displayOrder() {
        System.out.println("\n===== ORDER DETAILS =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);

        for (OrderItem item : items) {
            System.out.println(
                    item.getProduct().getName()
                            + " x " + item.getQuantity()
                            + " = $" + item.getSubtotal()
            );
        }

        System.out.println("Subtotal: $" + getTotal());
        System.out.println("Status: " + status);
    }
}