package com.aitu.ecommerce.decorator;

public class BasicOrder implements OrderComponent {
    private final double cost;

    public BasicOrder(double cost) {
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return "Basic Order";
    }
}