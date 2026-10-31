package com.aitu.ecommerce.factory;

import com.aitu.ecommerce.model.*;

public class ProductFactory {

    public static Product createProduct(
            String type,
            String id,
            String name,
            double price
    ) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Product type cannot be null"
            );
        }

        switch (type.toLowerCase()) {
            case "physical":
                return new PhysicalProduct(id, name, price);

            case "digital":
                return new DigitalProduct(id, name, price);

            default:
                throw new IllegalArgumentException(
                        "Unknown product type: " + type
                );
        }
    }
}