class Practice21_Separate_Files_BankLibraryEmployeeProductStudentVehiclePatient {

    static class BankAccount {
        static String bankName = "ABC Bank";
        static int totalAccounts = 0;

        final int accountNumber;
        String accountHolderName;
        double balance;

        BankAccount(String accountHolderName, int accountNumber, double balance) {
            this.accountHolderName = accountHolderName;
            this.accountNumber = accountNumber;
            this.balance = balance;
            totalAccounts++;
        }

        static int getTotalAccounts() {
            return totalAccounts;
        }
    }

    static class Book {
        static String libraryName = "Central Library";
        final String isbn;
        String title;
        String author;

        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        static void displayLibraryName() {
            System.out.print(libraryName);
        }
    }

    static class Employee {
        static String companyName = "Tech Corp";
        static int totalEmployees = 0;
        final int id;
        String name;
        String designation;

        Employee(String name, int id, String designation) {
            this.name = name;
            this.id = id;
            this.designation = designation;
            totalEmployees++;
        }

        static void displayTotalEmployees() {
            System.out.print(totalEmployees);
        }
    }

    static class Product {
        static double discount = 10;
        final String productID;
        String productName;
        double price;
        int quantity;

        Product(String productName, double price, int quantity, String productID) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.productID = productID;
        }

        static void updateDiscount(double discount) {
            Product.discount = discount;
        }
    }

    static class Student {
        static String universityName = "National University";
        static int totalStudents = 0;
        final int rollNumber;
        String name;
        String grade;

        Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            totalStudents++;
        }

        static void displayTotalStudents() {
            System.out.print(totalStudents);
        }
    }

    static class Vehicle {
        static double registrationFee = 500;
        final String registrationNumber;
        String ownerName;
        String vehicleType;

        Vehicle(String ownerName, String vehicleType, String registrationNumber) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
            this.registrationNumber = registrationNumber;
        }

        static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
        }
    }

    static class Patient {
        static String hospitalName = "City Hospital";
        static int totalPatients = 0;
        final String patientID;
        String name;
        int age;
        String ailment;

        Patient(String name, int age, String ailment, String patientID) {
            this.name = name;
            this.age = age;
            this.ailment = ailment;
            this.patientID = patientID;
            totalPatients++;
        }

        static int getTotalPatients() {
            return totalPatients;
        }
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount("A", 1, 100);
        System.out.print(BankAccount.getTotalAccounts());
    }
}

