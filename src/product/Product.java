package assessment3;

//Product.java
public class Product {
 protected String id;
 protected String name;
 protected String type;
 protected double price;

 // Constructor
 public Product(String id, String name, String type, double price) {
     this.id = id;
     this.name = name;
     this.type = type;
     this.price = price;
 }

 // Accessors
 public String getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public String getType() {
     return type;
 }

 public double getPrice() {
     return price;
 }

 // Tax (to be overridden if needed)
 public double getTaxComponent() {
     return 0.0;
 }

 // toString method
 public String toString() {
     return "ID: " + id + "\n"
          + "Name: " + name + "\n"
          + "Type: " + type + "\n"
          + "Price: $" + String.format("%.2f", price) + "\n"
          + "Tax: $" + String.format("%.2f", getTaxComponent());
 }
}
