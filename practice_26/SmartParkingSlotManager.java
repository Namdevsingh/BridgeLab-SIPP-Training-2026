import java.util.*;

public class SmartParkingSlotManager {

    static class ParkingManager {
        ArrayList<String> parkedVehicles;

        ParkingManager() {
            parkedVehicles = new ArrayList<>();
        }

        void enter(String vehicleNumber) {
            if (!parkedVehicles.contains(vehicleNumber)) parkedVehicles.add(vehicleNumber);
        }

        void exit(String vehicleNumber) {
            parkedVehicles.remove(vehicleNumber);
        }

        boolean isParked(String vehicleNumber) {
            return parkedVehicles.contains(vehicleNumber);
        }

        void displayAll() {
            System.out.println("Total occupied slots: " + parkedVehicles.size());
            for (String v : parkedVehicles) System.out.println(v);
        }
    }

    public static void main(String[] args) {
        ParkingManager pm = new ParkingManager();
        pm.enter("KA-01-1111");
        pm.enter("KA-01-2222");
        pm.enter("KA-01-3333");

        System.out.println("Is KA-01-2222 parked? " + pm.isParked("KA-01-2222"));
        pm.exit("KA-01-2222");

        pm.displayAll();
    }
}

