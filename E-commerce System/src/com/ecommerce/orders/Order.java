package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.util.List;

/**
 * The Order class represents an order made by a customer.
 * It contains information about the order, such as its ID, customer, products, and total price.
 */
public class Order {
    private static int nextOrderID = 1;

    private int orderID; // The unique identifier for the order
    private Customer customer; // The customer who placed the order
    private List<Product> products; // The list of products in the order
    private double orderTotal; // The total price of the order

    /**
     * Constructs a new Order object with the specified customer and products.
     *
     * @param customer The customer who placed the order.
     * @param products The list of products in the order.
     */
    public Order(Customer customer, List<Product> products) {
        this.orderID = nextOrderID++;
        this.customer = customer;
        this.products = products;
        this.orderTotal = calculateTotal();
    }

    /**
     * Calculates the total price of all products in the order.
     *
     * @return The total price of all products in the order.
     */
    private double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    /**
     * Displays a summary of the order, including order ID, customer information, products, and total price.
     */
    public void displayOrderSummary() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer ID: " + customer.getCustomerID());
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + ": $" + product.getPrice());
        }
        System.out.println("Total: $" + orderTotal);
    }
}
