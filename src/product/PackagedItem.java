package assessment3;

//PackagedItem.java
public class PackagedItem extends Product {
 private int unitCount;
 private String useByDate;

 // Constructor
 public PackagedItem(String id, String name, double price, int unitCount, String useByDate) {
     super(id, name, "Packaged Item", price);
     this.unitCount = unitCount;
     this.useByDate = useByDate;
 }

 // Accessors and mutators
 public int getUnitCount() {
     return unitCount;
 }

 public void setUnitCount(int unitCount) {
     this.unitCount = unitCount;
 }

 public String getUseByDate() {
     return useByDate;
 }

 public void setUseByDate(String useByDate) {
     this.useByDate = useByDate;
 }

 // Override tax method (10% tax)
 @Override
 public double getTaxComponent() {
     return price * 0.10;
 }

 // Override toString method
 @Override
 public String toString() {
     return super.toString() + "\n"
          + "Unit Count: " + unitCount + "\n"
          + "Use-By Date: " + useByDate;
 }
}
