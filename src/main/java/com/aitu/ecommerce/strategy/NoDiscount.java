package com.aitu.ecommerce.strategy;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double total) {
        return 0;
    }
}