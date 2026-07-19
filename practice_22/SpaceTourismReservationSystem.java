public class SpaceTourismReservationSystem {
    static class SpaceTourist {
        static int totalReservations = 0;
        static String missionName = "Artemis";

        String touristName;
        int seatNumber;

        SpaceTourist(String touristName, int seatNumber) {
            this.touristName = touristName;
            this.seatNumber = seatNumber;
            totalReservations++;
        }

        SpaceTourist updateSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        void displayFinalDetails() {
            System.out.print("Mission: " + missionName + "\nTourist: " + touristName + "\nSeat Number: " + seatNumber + "\nTotal Reservations: " + totalReservations);
        }
    }

    public static void main(String[] args) {
        SpaceTourist tourist = new SpaceTourist("Neha", 5);
        tourist.updateSeatNumber(10).updateSeatNumber(15);
        tourist.displayFinalDetails();
    }
}

