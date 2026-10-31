package com.aitu.ecommerce.strategy;

public class PercentageDiscount implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    "Discount must be between 0 and 100"
            );
        }

        this.percentage = percentage;
    }

    @Override
    public double calculateDiscount(double total) {
        return total * percentage / 100;
    }
}