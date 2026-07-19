public class ShoppingCartSimulation {
    static class CartItem {
        String itemName;
        double price;
        int quantity;

        CartItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        void addItem(int qtyToAdd) {
            if (qtyToAdd > 0) quantity += qtyToAdd;
        }

        void removeItem(int qtyToRemove) {
            if (qtyToRemove > 0) quantity -= qtyToRemove;
            if (quantity < 0) quantity = 0;
        }

        double totalCost() {
            return price * quantity;
        }

        void display() {
            System.out.print("Item: " + itemName + "\nPrice: " + price + "\nQuantity: " + quantity + "\nTotal: " + totalCost());
        }
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 50000, 1);
        item.addItem(1);
        item.removeItem(1);
        item.display();
    }
}

