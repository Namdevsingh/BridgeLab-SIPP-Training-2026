public class ItemTotalCost {
    static class Item {
        int itemCode;
        String itemName;
        double price;

        Item(int itemCode, String itemName, double price) {
            this.itemCode = itemCode;
            this.itemName = itemName;
            this.price = price;
        }

        double totalCost(int quantity) {
            return price * quantity;
        }

        void displayDetails() {
            System.out.print("Item Details\nCode: " + itemCode + "\nName: " + itemName + "\nPrice: " + price);
        }
    }

    public static void main(String[] args) {
        Item item = new Item(11, "Keyboard", 1500);
        item.displayDetails();
        System.out.print("\nTotal Cost for 3: " + item.totalCost(3));
    }
}

