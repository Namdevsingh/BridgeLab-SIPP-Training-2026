public class SmartHomeDevicesDeviceThermostat {

    static class Device {
        String deviceId;
        String status;

        Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        void displayStatus() {
            System.out.print("Device ID: " + deviceId + "\nStatus: " + status);
        }
    }

    static class Thermostat extends Device {
        int temperatureSetting;

        Thermostat(String deviceId, String status, int temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        void displayStatus() {
            System.out.print("Device ID: " + deviceId + "\nStatus: " + status + "\nTemp Setting: " + temperatureSetting + "C");
        }
    }

    public static void main(String[] args) {
        Device d1 = new Thermostat("T-101", "ON", 24);
        Device d2 = new Device("D-200", "OFF");

        d1.displayStatus();
        System.out.print("\n---\n");
        d2.displayStatus();
    }
}

