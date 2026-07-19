public class OnlineFoodDeliverySystemEncapsulationAbstraction {

    public static abstract class FoodItem {
        private String itemName;
        private double price;
        private int quantity;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public abstract double calculateTotalPrice();

        public void displayItemDetails() {
            System.out.println("ItemName: " + itemName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("TotalPrice: " + calculateTotalPrice());
        }
    }

    public static class VegItem extends FoodItem {
        public double calculateTotalPrice() {
            return getPrice() * getQuantity();
        }
    }

    public static class NonVegItem extends FoodItem {
        private double serviceCharge;

        public double getServiceCharge() {
            return serviceCharge;
        }

        public void setServiceCharge(double serviceCharge) {
            this.serviceCharge = serviceCharge;
        }

        public double calculateTotalPrice() {
            return (getPrice() * getQuantity()) + serviceCharge;
        }
    }

    public static void main(String[] args) {
        VegItem veg = new VegItem();
        veg.setItemName("Veg Pizza");
        veg.setPrice(300);
        veg.setQuantity(2);

        NonVegItem nonVeg = new NonVegItem();
        nonVeg.setItemName("Chicken Burger");
        nonVeg.setPrice(250);
        nonVeg.setQuantity(3);
        nonVeg.setServiceCharge(75);

        System.out.println("--- Veg Item ---");
        veg.displayItemDetails();
        System.out.println("--- NonVeg Item ---");
        nonVeg.displayItemDetails();
    }
}

