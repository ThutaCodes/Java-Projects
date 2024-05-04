package com.ecommerce;

/**
 * The Product class represents a product available for purchase in the e-commerce system.
 * It contains information about the product, such as its ID, name, and price.
 */
public class Product {
    private int productID; // The unique identifier for the product
    private String name; // The name of the product
    private double price; // The price of the product

    /**
     * Constructs a new Product object with the specified ID, name, and price.
     *
     * @param productID The ID of the product.
     * @param name      The name of the product.
     * @param price     The price of the product.
     */
    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    /**
     * Retrieves the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the ID of the product.
     *
     * @param productID The ID of the product.
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
