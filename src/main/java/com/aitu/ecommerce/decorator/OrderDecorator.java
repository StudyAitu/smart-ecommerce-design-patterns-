package com.aitu.ecommerce.decorator;

public abstract class OrderDecorator
        implements OrderComponent {

    protected final OrderComponent order;

    public OrderDecorator(OrderComponent order) {
        this.order = order;
    }
}