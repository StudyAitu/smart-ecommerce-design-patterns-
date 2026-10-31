package com.aitu.ecommerce.strategy;

public class StudentDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double total) {
        return total * 0.15;
    }
}