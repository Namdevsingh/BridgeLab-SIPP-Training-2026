public class DeliveryExecutiveFoodGroceryDefaultAndStatic {

    interface FoodDelivery {
        default void trackOrder() {
            System.out.print("Tracking food delivery order\n");
        }

        static String generateDeliveryCode() {
            return "FD-" + System.nanoTime();
        }
    }

    interface GroceryDelivery {
        default void trackOrder() {
            System.out.print("Tracking grocery delivery order\n");
        }
    }

    static class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
        String[] customerNames;

        DeliveryExecutive(String[] customerNames) {
            this.customerNames = customerNames;
        }

        void processDeliveries() {
            for (String c : customerNames) {
                String code = FoodDelivery.generateDeliveryCode();
                System.out.println("Customer: " + c + " | Code: " + code);
                if (c.hashCode() % 2 == 0) FoodDelivery.super.trackOrder();
                else GroceryDelivery.super.trackOrder();
                System.out.println("---");
            }
        }

        public void trackOrder() {
            FoodDelivery.super.trackOrder();
            GroceryDelivery.super.trackOrder();
        }
    }

    public static void main(String[] args) {
        String[] customers = {"Rahul", "Anita", "Kiran", "Sara"};
        DeliveryExecutive ex = new DeliveryExecutive(customers);
        ex.processDeliveries();
    }
}

