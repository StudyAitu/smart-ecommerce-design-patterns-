package com.aitu.ecommerce.model;

public class DigitalProduct extends Product {

    public DigitalProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String getType() {
        return "Digital";
    }
}