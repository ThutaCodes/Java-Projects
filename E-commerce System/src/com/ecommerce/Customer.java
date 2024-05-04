package com.ecommerce;

import com.ecommerce.orders.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class represents a customer in the e-commerce system.
 * It contains information about the customer, such as their ID, name, and shopping cart.
 * It also provides methods to manage the customer's shopping cart and calculate the total price of items in the cart.
 */
public class Customer {
    private int customerID; // The unique identifier for the customer
    private String name; // The name of the customer
    private List<Product> shoppingCart; // The list of products in the customer's shopping cart

    /**
     * Constructs a new Customer object with the specified ID and name.
     *
     * @param customerID The ID of the customer.
     * @param name       The name of the customer.
     */
    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    /**
     * Retrieves the ID of the customer.
     *
     * @return The ID of the customer.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param customerID The ID of the customer.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Retrieves the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the shopping cart of the customer.
     *
     * @return The shopping cart of the customer.
     */
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the shopping cart of the customer.
     *
     * @param shoppingCart The shopping cart of the customer.
     */
    public void setShoppingCart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Adds a product to the customer's shopping cart.
     *
     * @param product The product to add to the shopping cart.
     */
    public void addToCart(Product product) {
        shoppingCart.add(product);
    }

    /**
     * Removes a product from the customer's shopping cart.
     *
     * @param product The product to remove from the shopping cart.
     */
    public void removeFromCart(Product product) {
        shoppingCart.remove(product);
    }

    /**
     * Calculates the total price of all products in the customer's shopping cart.
     *
     * @return The total price of all products in the shopping cart.
     */
    public double calculateTotal() {
        double total = 0.0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    /**
     * Places an order for the customer.
     *
     * @param order The order to place.
     */
    public void placeOrder(Order order) {
        if (shoppingCart.isEmpty()) {
            System.out.println("Cannot place an empty order.");
            return;
        }
        // Here you would typically have logic to process the order, update inventory, etc.
        System.out.println("Order placed successfully.");
        shoppingCart.clear(); // Clear the shopping cart after placing the order
    }
}
