public class MovieTicketBooking {
    static class MovieTicket {
        String movieName;
        int seatNumber;
        double price;

        MovieTicket(String movieName) {
            this.movieName = movieName;
        }

        void bookTicket(int seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        void displayTicketDetails() {
            System.out.print("Movie: " + movieName + "\nSeat: " + seatNumber + "\nPrice: " + price);
        }
    }

    public static void main(String[] args) {
        MovieTicket t = new MovieTicket("Inception");
        t.bookTicket(8, 500);
        t.displayTicketDetails();
    }
}

