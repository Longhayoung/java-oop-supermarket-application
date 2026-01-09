package assessment3;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class Main {
	
    public static void main(String[] args) {
        List<Product> products = ProductLoader.loadProductsFromFile("src/Products.txt");
        Scanner scanner = new Scanner(System.in);
        List<Product> cart = new ArrayList<>();

        System.out.println("=== Supermarket Product Menu ===");
        for (Product p : products) {
            System.out.println("-------------------------");
            System.out.println(p);
        }

        System.out.println("\nStart adding products to your cart.");
        System.out.println("Enter product ID (or type 'done' to finish):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) break;

            boolean found = false;
            for (Product p : products) {
                if (p.getId().equalsIgnoreCase(input)) {
                    cart.add(p);
                    System.out.println(p.getName() + " added to cart.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Product ID not found. Try again.");
            }
        }

        printReceipt(cart);
        saveReceiptToFile(cart, "receipt.txt");

    }

    public static void printReceipt(List<Product> cart) {
        System.out.println("\n=== PURCHASE RECEIPT ===");
        double total = 0;
        double totalTax = 0;

        for (Product p : cart) {
            System.out.println("-------------------------");
            System.out.println(p);
            total += p.getPrice();
            totalTax += p.getTaxComponent();
        }

        System.out.println("=========================");
        System.out.printf("TOTAL: $%.2f\n", total);
        System.out.printf("Total Tax: $%.2f\n", totalTax);
    }
    public static void saveReceiptToFile(List<Product> cart, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=== PURCHASE RECEIPT ===");
            double total = 0;
            double totalTax = 0;

            for (Product p : cart) {
                writer.println("-------------------------");
                writer.println(p.toString());
                total += p.getPrice();
                totalTax += p.getTaxComponent();
            }

            writer.println("=========================");
            writer.printf("TOTAL: $%.2f%n", total);
            writer.printf("Total Tax: $%.2f%n", totalTax);

            System.out.println("Receipt saved to: " + filename);

        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
   
   


}
