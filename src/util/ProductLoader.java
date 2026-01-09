package assessment3;

import java.io.*;
import java.util.*;

public class ProductLoader {
    public static List<Product> loadProductsFromFile(String filename) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Skip comments or blank lines
                if (line.startsWith("#") || line.trim().isEmpty()) continue;

                String[] parts = line.split(",");

                String type = parts[0];
                String id = parts[1];
                String name = parts[2];
                double price = Double.parseDouble(parts[3]);

                if (type.equalsIgnoreCase("FreshFruit")) {
                    double weight = Double.parseDouble(parts[4]);
                    products.add(new FreshFruit(id, name, price, weight));
                } else if (type.equalsIgnoreCase("PackagedItem")) {
                    int unitCount = Integer.parseInt(parts[4]);
                    String useByDate = parts[5];
                    products.add(new PackagedItem(id, name, price, unitCount, useByDate));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return products;
    }
}
