package com.aitu.ecommerce;

import com.aitu.ecommerce.model.*;
import com.aitu.ecommerce.factory.ProductFactory;
import com.aitu.ecommerce.strategy.*;
import com.aitu.ecommerce.facade.ShoppingFacade;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("   SMART E-COMMERCE SYSTEM");
        System.out.println("================================");

        // FACTORY PATTERN
        Product laptop = ProductFactory.createProduct(
                "physical",
                "P001",
                "Laptop",
                1000.0
        );

        Product headphones = ProductFactory.createProduct(
                "physical",
                "P002",
                "Headphones",
                200.0
        );

        Product software = ProductFactory.createProduct(
                "digital",
                "P003",
                "Software License",
                100.0
        );

        System.out.println("\nAVAILABLE PRODUCTS:");

        System.out.println("1. " + laptop);
        System.out.println("2. " + headphones);
        System.out.println("3. " + software);

        System.out.print("\nEnter customer name: ");
        String customerName = scanner.nextLine();

        System.out.println("\nChoose discount strategy:");
        System.out.println("1. No discount");
        System.out.println("2. 10% discount");
        System.out.println("3. Student discount (15%)");

        int choice = Integer.parseInt(scanner.nextLine());

        DiscountStrategy strategy;

        switch (choice) {
            case 1:
                strategy = new NoDiscount();
                break;

            case 2:
                strategy = new PercentageDiscount(10);
                break;

            case 3:
                strategy = new StudentDiscount();
                break;

            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        System.out.print("\nChoose first product (1-3): ");
        int firstChoice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter quantity: ");
        int firstQuantity = Integer.parseInt(scanner.nextLine());

        System.out.print("\nChoose second product (1-3): ");
        int secondChoice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter quantity: ");
        int secondQuantity = Integer.parseInt(scanner.nextLine());

        Product[] products = {
                laptop,
                headphones,
                software
        };

        if (firstChoice < 1 || firstChoice > 3
                || secondChoice < 1 || secondChoice > 3
                || firstQuantity <= 0
                || secondQuantity <= 0) {

            System.out.println("Invalid product or quantity.");
            scanner.close();
            return;
        }

        System.out.print("\nAdd gift wrapping? (yes/no): ");
        boolean giftWrapping =
                scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Add express delivery? (yes/no): ");
        boolean expressDelivery =
                scanner.nextLine().equalsIgnoreCase("yes");

        // FACADE PATTERN
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        shoppingFacade.checkout(
                customerName,
                products[firstChoice - 1],
                firstQuantity,
                products[secondChoice - 1],
                secondQuantity,
                strategy,
                giftWrapping,
                expressDelivery
        );

        scanner.close();
    }
}