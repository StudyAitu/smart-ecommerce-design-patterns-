package com.aitu.ecommerce.facade;

import com.aitu.ecommerce.model.*;
import com.aitu.ecommerce.builder.OrderBuilder;
import com.aitu.ecommerce.strategy.*;
import com.aitu.ecommerce.observer.*;
import com.aitu.ecommerce.decorator.*;

public class ShoppingFacade {

    private final OrderSubject orderSubject;

    public ShoppingFacade() {
        this.orderSubject = new OrderSubject();
    }

    public Order checkout(
            String customerName,
            Product product1,
            int quantity1,
            Product product2,
            int quantity2,
            DiscountStrategy discountStrategy,
            boolean giftWrapping,
            boolean expressDelivery
    ) {
        System.out.println("\n--- CHECKOUT PROCESS ---");

        // 1. Build the order
        Order order = new OrderBuilder()
                .setCustomerName(customerName)
                .addProduct(product1, quantity1)
                .addProduct(product2, quantity2)
                .build();

        System.out.println("[Builder] Order created.");

        // 2. Subscribe customer to notifications
        CustomerNotifier notifier =
                new CustomerNotifier(customerName);

        orderSubject.addObserver(notifier);

        // 3. Calculate discount using Strategy
        double subtotal = order.getTotal();

        double discount =
                discountStrategy.calculateDiscount(subtotal);

        // 4. Add optional services using Decorator
        OrderComponent decoratedOrder =
                new BasicOrder(subtotal);

        if (giftWrapping) {
            decoratedOrder =
                    new GiftWrapping(decoratedOrder);
        }

        if (expressDelivery) {
            decoratedOrder =
                    new ExpressDelivery(decoratedOrder);
        }

        double additionalServices =
                decoratedOrder.getCost() - subtotal;

        double finalPrice =
                subtotal - discount + additionalServices;

        // 5. Display the order
        order.displayOrder();

        System.out.println(
                "[Strategy] Discount: $" + discount
        );

        System.out.println(
                "[Decorator] Services: "
                        + decoratedOrder.getDescription()
        );

        System.out.println(
                "[Decorator] Additional cost: $"
                        + additionalServices
        );

        System.out.println(
                "FINAL PRICE: $" + finalPrice
        );

        // 6. Notify customer about status changes
        order.setStatus("CONFIRMED");

        orderSubject.notifyObservers(
                order.getOrderId(),
                order.getStatus()
        );

        orderSubject.removeObserver(notifier);

        System.out.println("--- CHECKOUT COMPLETED ---");

        return order;
    }
}