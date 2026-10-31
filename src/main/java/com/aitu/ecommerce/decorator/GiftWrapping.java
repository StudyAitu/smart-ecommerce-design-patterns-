package com.aitu.ecommerce.decorator;

public class GiftWrapping extends OrderDecorator {

    public GiftWrapping(OrderComponent order) {
        super(order);
    }

    @Override
    public double getCost() {
        return order.getCost() + 5.0;
    }

    @Override
    public String getDescription() {
        return order.getDescription() + " + Gift Wrapping";
    }
}