package com.aitu.ecommerce.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderSubject {
    private final List<OrderObserver> observers =
            new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(
            String orderId,
            String status
    ) {
        for (OrderObserver observer : observers) {
            observer.update(orderId, status);
        }
    }
}