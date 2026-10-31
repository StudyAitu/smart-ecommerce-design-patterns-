package com.aitu.ecommerce.observer;

public class CustomerNotifier implements OrderObserver {

    private final String customerName;

    public CustomerNotifier(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String orderId, String status) {
        System.out.println(
                "[NOTIFICATION] Hello " + customerName
                        + "! Order " + orderId
                        + " status changed to: " + status
        );
    }
}