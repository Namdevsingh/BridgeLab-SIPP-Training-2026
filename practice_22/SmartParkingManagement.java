public class SmartParkingManagement {
    static class Vehicle {
        String vehicleNumber;
        String ownerName;
        String vehicleType;

        Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
            this.vehicleNumber = vehicleNumber;
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }

        void display() {
            System.out.print("Number: " + vehicleNumber + "\nOwner: " + ownerName + "\nType: " + vehicleType);
        }
    }

    static void displayCars(Vehicle[] vehicles) {
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("car")) {
                System.out.print("\n---\n");
                v.display();
            }
        }
    }

    static void displayBikes(Vehicle[] vehicles) {
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("bike")) {
                System.out.print("\n---\n");
                v.display();
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];
        vehicles[0] = new Vehicle("KA-01-1001", "Rahul", "car");
        vehicles[1] = new Vehicle("KA-01-1002", "Anita", "bike");
        vehicles[2] = new Vehicle("KA-01-1003", "Kiran", "car");
        vehicles[3] = new Vehicle("KA-01-1004", "Sara", "bike");
        vehicles[4] = new Vehicle("KA-01-1005", "Naveen", "car");
        vehicles[5] = new Vehicle("KA-01-1006", "Meera", "bike");

        System.out.print("Cars:\n");
        displayCars(vehicles);
        System.out.print("\n\nBikes:\n");
        displayBikes(vehicles);
    }
}

