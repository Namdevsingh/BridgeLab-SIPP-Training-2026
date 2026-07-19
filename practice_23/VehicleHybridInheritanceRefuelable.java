public class VehicleHybridInheritanceRefuelable {

    interface Refuelable {
        void refuel();
    }

    static class Vehicle {
        int maxSpeed;
        String model;

        Vehicle(String model, int maxSpeed) {
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        String getDetails() {
            return "Vehicle{model='" + model + "', maxSpeed=" + maxSpeed + "}";
        }
    }

    static class ElectricVehicle extends Vehicle {
        int chargeLevel;

        ElectricVehicle(String model, int maxSpeed, int chargeLevel) {
            super(model, maxSpeed);
            this.chargeLevel = chargeLevel;
        }

        void charge() {
            chargeLevel += 20;
        }

        String getDetails() {
            return "ElectricVehicle{" + super.getDetails() + ", chargeLevel=" + chargeLevel + "}";
        }
    }

    static class PetrolVehicle extends Vehicle implements Refuelable {
        double fuelLevel;

        PetrolVehicle(String model, int maxSpeed, double fuelLevel) {
            super(model, maxSpeed);
            this.fuelLevel = fuelLevel;
        }

        public void refuel() {
            fuelLevel += 5;
        }

        String getDetails() {
            return "PetrolVehicle{" + super.getDetails() + ", fuelLevel=" + fuelLevel + "}";
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new ElectricVehicle("EV-1", 180, 40);
        Vehicle v2 = new PetrolVehicle("PET-1", 160, 2.5);

        System.out.println(((ElectricVehicle) v1).getDetails());
        ((ElectricVehicle) v1).charge();
        System.out.println(((ElectricVehicle) v1).getDetails());

        System.out.println(((PetrolVehicle) v2).getDetails());
        ((PetrolVehicle) v2).refuel();
        System.out.println(((PetrolVehicle) v2).getDetails());
    }
}

