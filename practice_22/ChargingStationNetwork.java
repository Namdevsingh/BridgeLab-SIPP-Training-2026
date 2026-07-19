public class ChargingStationNetwork {
    static class ChargingStation {
        static int totalStations = 0;
        static double electricityRate = 12.5;

        int stationId;
        double unitsConsumed;

        ChargingStation(double unitsConsumed) {
            this.stationId = ++totalStations;
            this.unitsConsumed = unitsConsumed;
        }

        double calculateBill() {
            return unitsConsumed * electricityRate;
        }

        void displayStationDetails() {
            System.out.print("Station ID: " + stationId + "\nUnits: " + unitsConsumed + "\nRate: " + electricityRate + "\nBill: " + calculateBill() + "\n---\n");
        }

        static void updateElectricityRate(double newRate) {
            electricityRate = newRate;
        }
    }

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation(10);
        ChargingStation s2 = new ChargingStation(25);
        ChargingStation s3 = new ChargingStation(15);
        ChargingStation s4 = new ChargingStation(30);
        ChargingStation s5 = new ChargingStation(8);

        ChargingStation.updateElectricityRate(18.0);

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
    }
}

