public class MobilePhoneDetails {
    static class MobilePhone {
        String brand;
        String model;
        double price;

        MobilePhone(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        void display() {
            System.out.print("Brand: " + brand + "\nModel: " + model + "\nPrice: " + price);
        }
    }

    public static void main(String[] args) {
        MobilePhone p1 = new MobilePhone("Samsung", "A12", 18000);
        p1.display();
        System.out.print("\n---\n");
        MobilePhone p2 = new MobilePhone("Apple", "iPhone 12", 65000);
        p2.display();
    }
}

