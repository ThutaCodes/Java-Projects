package com.ecommerce;

import com.ecommerce.orders.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Main class contains the main method to run the e-commerce application.
 * It allows users to interactively select products to purchase and generates an order summary.
 *
 * @author Thuta Tun
 * @Date: 13.2.2024
 **/
public class Main {
    /**
     * The main method of the e-commerce application.
     * It prompts the user to enter their name, displays available products,
     * allows the user to select products to purchase, creates an order,
     * and displays the order summary.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to enter their name
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(1, customerName); // Assuming customer ID is 1

        // Reading products from a text file
        List<Product> productList = readProductsFromFile();

        // Displaying available products
        System.out.println("Available Products:");
        System.out.println("ID\tName\t\t\t\tPrice"); // Adjusted to accommodate longer product names
        for (Product product : productList) {
            System.out.printf("%d\t%-20s$%.2f\n", product.getProductID(), product.getName(), product.getPrice());
        }

        // Prompting the user to choose products by their IDs
        List<Product> selectedProducts = new ArrayList<>();
        while (true) {
            System.out.print("Enter the ID of the product you want to add to your cart (or type 'done' to finish): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int productID = Integer.parseInt(input);
                boolean found = false;
                for (Product product : productList) {
                    if (product.getProductID() == productID) {
                        selectedProducts.add(product);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid product ID. Please enter a valid product ID.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid product ID.");
            }
        }

        // Creating an order
        Order order = new Order(customer, selectedProducts);

        // Displaying the order summary
        System.out.println("\nOrder Summary:");
        order.displayOrderSummary();

        // Closing the scanner
        scanner.close();
    }

    /**
     * Reads products from a text file and returns a list of Product objects.
     *
     * @return A list of Product objects read from the file.
     */

    // Method to read products from a text file
    private static List<Product> readProductsFromFile() {
        List<Product> productList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            int productID = 1; // Assuming product IDs start from 1
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String productName = parts[0];
                double productPrice = Double.parseDouble(parts[1]);
                productList.add(new Product(productID++, productName, productPrice));
            }
        } catch (IOException e) {
            System.err.println("Error reading products from file: " + e.getMessage());
        }
        return productList;
    }
}
