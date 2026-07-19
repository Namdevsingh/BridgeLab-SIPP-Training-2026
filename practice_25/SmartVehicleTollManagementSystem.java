public class SmartVehicleTollManagementSystem {

    static class Vehicle {
        String vehicleNumber;
        String ownerName;

        Vehicle(String vehicleNumber, String ownerName) {
            this.vehicleNumber = vehicleNumber;
            this.ownerName = ownerName;
        }

        double calculateToll() {
            return 0;
        }

        String getType() {
            return "Vehicle";
        }

        public String toString() {
            return getType() + "{vehicleNumber='" + vehicleNumber + "', ownerName='" + ownerName + "'}";
        }
    }

    static class Car extends Vehicle {
        Car(String vehicleNumber, String ownerName) {
            super(vehicleNumber, ownerName);
        }

        double calculateToll() {
            return 50;
        }

        String getType() {
            return "Car";
        }
    }

    static class Bus extends Vehicle {
        Bus(String vehicleNumber, String ownerName) {
            super(vehicleNumber, ownerName);
        }

        double calculateToll() {
            return 120;
        }

        String getType() {
            return "Bus";
        }
    }

    static class Truck extends Vehicle {
        Truck(String vehicleNumber, String ownerName) {
            super(vehicleNumber, ownerName);
        }

        double calculateToll() {
            return 200;
        }

        String getType() {
            return "Truck";
        }
    }

    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double sum = 0;
        for (Vehicle v : vehicles) sum += v.calculateToll();
        return sum;
    }

    static Vehicle searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equals(vehicleNumber)) return v;
        }
        return null;
    }

    static Vehicle highestToll(Vehicle[] vehicles) {
        Vehicle best = null;
        double max = -1;
        for (Vehicle v : vehicles) {
            double t = v.calculateToll();
            if (t > max) {
                max = t;
                best = v;
            }
        }
        return best;
    }

    static int countType(Vehicle[] vehicles, String type) {
        int c = 0;
        for (Vehicle v : vehicles) if (v.getType().equalsIgnoreCase(type)) c++;
        return c;
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[7];
        vehicles[0] = new Car("C-100", "Rahul");
        vehicles[1] = new Bus("B-200", "Anita");
        vehicles[2] = new Truck("T-300", "Kiran");
        vehicles[3] = new Car("C-101", "Sara");
        vehicles[4] = new Bus("B-201", "Naveen");
        vehicles[5] = new Truck("T-301", "Meera");
        vehicles[6] = new Car("C-102", "Asha");

        System.out.println("Total Revenue: " + calculateTotalRevenue(vehicles));

        Vehicle found = searchVehicle(vehicles, "B-200");
        System.out.println("Search Result: " + (found == null ? "Not found" : found));

        Vehicle best = highestToll(vehicles);
        System.out.println("Highest Toll Paid: " + best + " | Toll: " + best.calculateToll());

        System.out.println("Cars: " + countType(vehicles, "Car"));
        System.out.println("Buses: " + countType(vehicles, "Bus"));
        System.out.println("Trucks: " + countType(vehicles, "Truck"));
    }
}

