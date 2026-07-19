public class TrackableReportableNotifiableFitnessDevice {

    interface Trackable {
        void logActivity();

        default void resetData() {
            System.out.print("Data reset\n");
        }
    }

    interface Reportable {
        void generateReport();
    }

    interface Notifiable {
        void sendAlert();
    }

    static class FitnessDevice implements Trackable, Reportable, Notifiable {
        public void logActivity() {
            System.out.print("Activity logged\n");
        }

        public void generateReport() {
            System.out.print("Report generated\n");
        }

        public void sendAlert() {
            System.out.print("Alert sent\n");
        }
    }

    public static void main(String[] args) {
        FitnessDevice d = new FitnessDevice();
        d.logActivity();
        d.generateReport();
        d.sendAlert();
        d.resetData();
    }
}

