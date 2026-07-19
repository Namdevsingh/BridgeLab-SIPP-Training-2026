public class TransportFleetFuelCostOpenClosed {
    static abstract class Vehicle {
        String vehicleId;

        Vehicle(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        abstract double fuelCost(int km);
    }

    static class Car extends Vehicle {
        Car(String vehicleId) {
            super(vehicleId);
        }

        double fuelCost(int km) {
            return km * 0.08;
        }
    }

    static class Bus extends Vehicle {
        Bus(String vehicleId) {
            super(vehicleId);
        }

        double fuelCost(int km) {
            return km * 0.03;
        }
    }

    static class Bike extends Vehicle {
        Bike(String vehicleId) {
            super(vehicleId);
        }

        double fuelCost(int km) {
            return km * 0.01;
        }
    }

    static class ElectricCar extends Car {
        ElectricCar(String vehicleId) {
            super(vehicleId);
        }

        double fuelCost(int km) {
            return km * 0.02;
        }
    }

    static void displayFuelCost(Vehicle v, int km) {
        if (v instanceof Car) {
            Car c = (Car) v;
            System.out.println("Car fuel cost: " + c.fuelCost(km));
        } else if (v instanceof Bus) {
            Bus b = (Bus) v;
            System.out.println("Bus fuel cost: " + b.fuelCost(km));
        } else if (v instanceof Bike) {
            Bike bi = (Bike) v;
            System.out.println("Bike fuel cost: " + bi.fuelCost(km));
        } else {
            System.out.println("Unknown vehicle fuel cost: " + v.fuelCost(km));
        }
    }

    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[4];
        fleet[0] = new Car("C-1");
        fleet[1] = new Bus("B-1");
        fleet[2] = new Bike("BI-1");
        fleet[3] = new ElectricCar("EC-1");

        int km = 120;
        for (Vehicle v : fleet) {
            System.out.println("Vehicle: " + v.vehicleId);
            displayFuelCost(v, km);
        }
    }
}

