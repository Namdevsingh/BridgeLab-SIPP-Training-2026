public class DroneDeliverySystemCompanyNameShared {
    static class Drone {
        String droneId;
        int batteryPercentage;
        static String companyName = "SkyRush";

        Drone(String droneId, int batteryPercentage) {
            this.droneId = droneId;
            this.batteryPercentage = batteryPercentage;
        }

        void startDelivery() {
            if (batteryPercentage > 0) {
                batteryPercentage -= 10;
                System.out.print("Drone " + droneId + " started delivery. Battery: " + batteryPercentage + "%\n");
            }
        }

        void displayStatus() {
            System.out.print("Drone ID: " + droneId + "\nBattery: " + batteryPercentage + "%\nCompany: " + companyName + "\n---\n");
        }
    }

    public static void main(String[] args) {
        Drone d1 = new Drone("D-1", 90);
        Drone d2 = new Drone("D-2", 75);
        Drone d3 = new Drone("D-3", 60);

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        System.out.print("Shared company name: " + Drone.companyName);
    }
}

