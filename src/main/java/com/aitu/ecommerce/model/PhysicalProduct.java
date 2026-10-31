package com.aitu.ecommerce.model;

public class PhysicalProduct extends Product {

    public PhysicalProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String getType() {
        return "Physical";
    }
}