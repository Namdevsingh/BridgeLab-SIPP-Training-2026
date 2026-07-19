public class VehicleRentalSystemAbstractionEncapsulation {

    public static abstract class Vehicle {
        private String vehicleNumber;
        private String vehicleType;

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }
    
        public abstract double calculateRentalCost(int days);
    }

    public static class Car extends Vehicle {
        private double dailyRate;

        public double getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        public double calculateRentalCost(int days) {
            return days * dailyRate;
        }
    }

    public static class Bike extends Vehicle {
        private double dailyRate;

        public double getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        public double calculateRentalCost(int days) {
            return days * dailyRate;
        }
    }

    public static class Truck extends Vehicle {
        private double dailyRate;
        private double loadingCharge;

        public double getDailyRate() {
            return dailyRate;
        }

        public void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        public double getLoadingCharge() {
            return loadingCharge;
        }

        public void setLoadingCharge(double loadingCharge) {
            this.loadingCharge = loadingCharge;
        }

        public double calculateRentalCost(int days) {
            return (days * dailyRate) + loadingCharge;
        }
    }

    public static void main(String[] args) {
        int days = 5;

        Car car = new Car();
        car.setVehicleNumber("CAR-001");
        car.setVehicleType("Car");
        car.setDailyRate(2500);

        Bike bike = new Bike();
        bike.setVehicleNumber("BIKE-010");
        bike.setVehicleType("Bike");
        bike.setDailyRate(800);

        Truck truck = new Truck();
        truck.setVehicleNumber("TRUCK-100");
        truck.setVehicleType("Truck");
        truck.setDailyRate(5000);
        truck.setLoadingCharge(1200);

        System.out.println("Car: " + car.getVehicleNumber() + " cost for " + days + " days = " + car.calculateRentalCost(days));
        System.out.println("Bike: " + bike.getVehicleNumber() + " cost for " + days + " days = " + bike.calculateRentalCost(days));
        System.out.println("Truck: " + truck.getVehicleNumber() + " cost for " + days + " days = " + truck.calculateRentalCost(days));
    }
}

