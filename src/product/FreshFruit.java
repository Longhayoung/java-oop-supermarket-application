package assessment3;

//FreshFruit.java
public class FreshFruit extends Product {
 private double weightInGrams;

 // Constructor
 public FreshFruit(String id, String name, double price, double weightInGrams) {
     super(id, name, "Fresh Fruit", price);
     this.weightInGrams = weightInGrams;
 }

 // Accessor and mutator
 public double getWeightInGrams() {
     return weightInGrams;
 }

 public void setWeightInGrams(double weightInGrams) {
     this.weightInGrams = weightInGrams;
 }

 // Override tax method (0% tax)
 @Override
 public double getTaxComponent() {
     return 0.0;
 }

 // Override toString method
 @Override
 public String toString() {
     return super.toString() + "\n"
          + "Weight: " + weightInGrams + "g";
 }
}
