public class HealthMonitoringSystem {

    interface HeartRateMonitor {
        int getHeartRate();

        default void displayHealthTips() {
            System.out.print("Tip: Stay hydrated and manage stress\n");
        }
    }

    interface TemperatureMonitor {
        double getTemperature();

        default void displayHealthTips() {
            System.out.print("Tip: Monitor fever and rest\n");
        }
    }

    static class PatientDevice implements HeartRateMonitor, TemperatureMonitor {
        int heartRate;
        double temperature;

        PatientDevice(int heartRate, double temperature) {
            this.heartRate = heartRate;
            this.temperature = temperature;
        }

        public int getHeartRate() {
            return heartRate;
        }

        public double getTemperature() {
            return temperature;
        }
    }

    static class SystemController {
        static boolean isPatientIdValid(String patientId) {
            return patientId != null && patientId.matches("P\\d{3}");
        }

        static void generateReport(String[] patientNames, String[] patientIds, PatientDevice[] devices) {
            HealthMonitoringSystem.AppHealth sys = new HealthMonitoringSystem.AppHealth();
            System.out.println("Health Tips:");
            sys.displayHealthTips();

            for (int i = 0; i < patientNames.length; i++) {
                System.out.println("\nPatient: " + patientNames[i]);
                if (!isPatientIdValid(patientIds[i])) {
                    System.out.println("Invalid patient ID");
                    continue;
                }
                System.out.println("Patient ID: " + patientIds[i]);
                System.out.println("Heart Rate: " + devices[i].getHeartRate());
                System.out.println("Temperature: " + devices[i].getTemperature() + " C");
                if (devices[i].getTemperature() > 37.5) System.out.println("Status: At risk (fever)");
                else System.out.println("Status: Normal");
            }
        }
    }

    static class AppHealth implements HeartRateMonitor, TemperatureMonitor {
        public int getHeartRate() { return 0; }
        public double getTemperature() { return 0; }

        public void displayHealthTips() {
            HeartRateMonitor.super.displayHealthTips();
            TemperatureMonitor.super.displayHealthTips();
        }
    }

    public static void main(String[] args) {
        String[] names = {"Asha", "Rahul", "Naveen"};
        String[] ids = {"P101", "X202", "P303"};
        PatientDevice[] devices = {
                new PatientDevice(78, 36.7),
                new PatientDevice(92, 38.1),
                new PatientDevice(70, 37.0)
        };

        SystemController.generateReport(names, ids, devices);
    }
}

