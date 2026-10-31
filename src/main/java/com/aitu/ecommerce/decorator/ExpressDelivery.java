package com.aitu.ecommerce.decorator;

public class ExpressDelivery extends OrderDecorator {

    public ExpressDelivery(OrderComponent order) {
        super(order);
    }

    @Override
    public double getCost() {
        return order.getCost() + 10.0;
    }

    @Override
    public String getDescription() {
        return order.getDescription() + " + Express Delivery";
    }
}