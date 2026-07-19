class Practice20_Constructors_BookCirclePersonHotelBookCarRental {

    static class Book {
        String title;
        String author;
        double price;

        Book() {
            this.title = "";
            this.author = "";
            this.price = 0;
        }

        Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        void display() {
            System.out.print("Title: " + title + "\nAuthor: " + author + "\nPrice: " + price);
        }
    }

    static class Circle {
        double radius;

        Circle() {
            this(1);
        }

        Circle(double radius) {
            this.radius = radius;
        }

        double area() {
            return Math.PI * radius * radius;
        }

        double circumference() {
            return 2 * Math.PI * radius;
        }

        void display() {
            System.out.print("Radius: " + radius + "\nArea: " + area() + "\nCircumference: " + circumference());
        }
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        Person(Person other) {
            this.name = other.name;
            this.age = other.age;
        }

        void display() {
            System.out.print("Name: " + name + "\nAge: " + age);
        }
    }

    static class HotelBooking {
        String guestName;
        String roomType;
        int nights;

        HotelBooking() {
            this.guestName = "";
            this.roomType = "";
            this.nights = 0;
        }

        HotelBooking(String guestName, String roomType, int nights) {
            this.guestName = guestName;
            this.roomType = roomType;
            this.nights = nights;
        }

        HotelBooking(HotelBooking other) {
            this.guestName = other.guestName;
            this.roomType = other.roomType;
            this.nights = other.nights;
        }

        void display() {
            System.out.print("Guest: " + guestName + "\nRoom Type: " + roomType + "\nNights: " + nights);
        }

        double totalCost() {
            double perNight;
            if (roomType.equalsIgnoreCase("Deluxe")) perNight = 5000;
            else if (roomType.equalsIgnoreCase("Suite")) perNight = 9000;
            else perNight = 2500;
            return perNight * nights;
        }
    }

    static class LibraryBook {
        String title;
        String author;
        double price;
        boolean available;

        LibraryBook() {
            this.title = "";
            this.author = "";
            this.price = 0;
            this.available = true;
        }

        LibraryBook(String title, String author, double price, boolean available) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.available = available;
        }

        void borrow() {
            if (available) {
                available = false;
                System.out.print("Borrowed: " + title);
            } else {
                System.out.print("Not available: " + title);
            }
        }
    }

    static class CarRental {
        String customerName;
        String carModel;
        int rentalDays;

        CarRental() {
            this.customerName = "";
            this.carModel = "";
            this.rentalDays = 0;
        }

        CarRental(String customerName, String carModel, int rentalDays) {
            this.customerName = customerName;
            this.carModel = carModel;
            this.rentalDays = rentalDays;
        }

        double totalCost() {
            double perDay;
            if (carModel.equalsIgnoreCase("Hatchback")) perDay = 1500;
            else if (carModel.equalsIgnoreCase("Sedan")) perDay = 2500;
            else perDay = 3500;
            return perDay * rentalDays;
        }

        void display() {
            System.out.print("Customer: " + customerName + "\nCar: " + carModel + "\nDays: " + rentalDays + "\nTotal: " + totalCost());
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Basics", "John", 999.5);
        b2.display();

        System.out.print("\n\n");

        Circle c1 = new Circle();
        Circle c2 = new Circle(3.5);
        c2.display();

        System.out.print("\n\n");

        Person p1 = new Person("Rahul", 25);
        Person p2 = new Person(p1);
        p2.display();

        System.out.print("\n\n");

        HotelBooking hb1 = new HotelBooking("Anita", "Deluxe", 4);
        HotelBooking hb2 = new HotelBooking(hb1);
        hb2.display();
        System.out.print("\nTotal Cost: " + hb2.totalCost());

        System.out.print("\n\n");

        LibraryBook lb = new LibraryBook("C++", "Bjarne", 799, true);
        lb.borrow();

        System.out.print("\n\n");

        CarRental cr = new CarRental("Kiran", "Sedan", 3);
        cr.display();
    }
}

