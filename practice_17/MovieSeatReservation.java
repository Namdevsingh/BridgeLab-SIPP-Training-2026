public class MovieSeatReservation {
    static int[] seats = {101, 102, 103, 104, 105};

    static int getSeat(int index) {
        try {
            return seats[index];
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        int seatIndex = 8;
        int seat = getSeat(seatIndex);
        System.out.print(seat);
    }
}

