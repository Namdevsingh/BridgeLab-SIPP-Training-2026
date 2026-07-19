public class HospitalPatientManagementSystemEncapsulationAbstraction {

    public static abstract class Patient {
        private int patientId;
        private String name;
        private int age;

        public int getPatientId() {
            return patientId;
        }

        public void setPatientId(int patientId) {
            this.patientId = patientId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public abstract double calculateBill();

        public void displayPatientDetails() {
            System.out.println("PatientId: " + patientId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Bill: " + calculateBill());
        }
    }

    public static class InPatient extends Patient {
        private double roomCharges;
        private double treatmentCharges;

        public double getRoomCharges() {
            return roomCharges;
        }

        public void setRoomCharges(double roomCharges) {
            this.roomCharges = roomCharges;
        }

        public double getTreatmentCharges() {
            return treatmentCharges;
        }

        public void setTreatmentCharges(double treatmentCharges) {
            this.treatmentCharges = treatmentCharges;
        }

        public double calculateBill() {
            return roomCharges + treatmentCharges;
        }
    }

    public static class OutPatient extends Patient {
        private double consultationFee;
        private double treatmentCharges;

        public double getConsultationFee() {
            return consultationFee;
        }

        public void setConsultationFee(double consultationFee) {
            this.consultationFee = consultationFee;
        }

        public double getTreatmentCharges() {
            return treatmentCharges;
        }

        public void setTreatmentCharges(double treatmentCharges) {
            this.treatmentCharges = treatmentCharges;
        }

        public double calculateBill() {
            return consultationFee + treatmentCharges;
        }
    }

    public static void main(String[] args) {
        InPatient in = new InPatient();
        in.setPatientId(1);
        in.setName("John");
        in.setAge(45);
        in.setRoomCharges(2500);
        in.setTreatmentCharges(4000);

        OutPatient out = new OutPatient();
        out.setPatientId(2);
        out.setName("Sophia");
        out.setAge(30);
        out.setConsultationFee(500);
        out.setTreatmentCharges(1200);

        System.out.println("--- InPatient ---");
        in.displayPatientDetails();
        System.out.println("--- OutPatient ---");
        out.displayPatientDetails();
    }
}

