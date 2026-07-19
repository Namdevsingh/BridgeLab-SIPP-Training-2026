class Practice21_StaticThisFinalInstanceof_BankLibraryEmployeeShoppingCartUniversityVehicleHospital {

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
            System.out.print("Total Accounts: " + totalAccounts);
            return totalAccounts;
        }

        void displayDetails(Object obj) {
            if (obj instanceof BankAccount) {
                BankAccount a = (BankAccount) obj;
                System.out.print("\nBank: " + bankName + "\nHolder: " + a.accountHolderName + "\nAcc No: " + a.accountNumber + "\nBalance: " + a.balance);
            }
        }
    }

    static class Book {
        static String libraryName = "Central Library";
        static int totalBooks = 0;

        final String isbn;
        String title;
        String author;

        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            totalBooks++;
        }

        static void displayLibraryName() {
            System.out.print("\nLibrary Name: " + libraryName);
        }

        void displayDetails(Object obj) {
            if (obj instanceof Book) {
                Book b = (Book) obj;
                System.out.print("\nBook: " + b.title + "\nAuthor: " + b.author + "\nISBN: " + b.isbn);
            }
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
            System.out.print("\nTotal Employees: " + totalEmployees);
        }

        void displayDetails(Object obj) {
            if (obj instanceof Employee) {
                Employee e = (Employee) obj;
                System.out.print("\nEmployee: " + e.name + "\nID: " + e.id + "\nDesignation: " + e.designation);
            }
        }
    }

    static class Product {
        static double discount = 10;
        static String lastUpdateNote = "";

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

        static void updateDiscount(double newDiscount) {
            discount = newDiscount;
            lastUpdateNote = "Discount updated";
        }

        void processDetails(Object obj) {
            if (obj instanceof Product) {
                Product p = (Product) obj;
                System.out.print("\nProduct: " + p.productName + "\nPrice: " + p.price + "\nQty: " + p.quantity + "\nID: " + p.productID + "\nDiscount(%): " + discount);
            }
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
            System.out.print("\nTotal Students: " + totalStudents);
        }

        void displayStudent(Object obj) {
            if (obj instanceof Student) {
                Student s = (Student) obj;
                System.out.print("\nUniversity: " + universityName + "\nStudent: " + s.name + "\nRoll: " + s.rollNumber + "\nGrade: " + s.grade);
            }
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

        void displayRegistration(Object obj) {
            if (obj instanceof Vehicle) {
                Vehicle v = (Vehicle) obj;
                System.out.print("\nOwner: " + v.ownerName + "\nType: " + v.vehicleType + "\nReg No: " + v.registrationNumber + "\nReg Fee: " + registrationFee);
            }
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
            System.out.print("\nTotal Patients: " + totalPatients);
            return totalPatients;
        }

        void displayDetails(Object obj) {
            if (obj instanceof Patient) {
                Patient p = (Patient) obj;
                System.out.print("\nHospital: " + hospitalName + "\nPatient: " + p.name + "\nAge: " + p.age + "\nAilment: " + p.ailment + "\nPatient ID: " + p.patientID);
            }
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Ravi", 1001, 2500);
        BankAccount.getTotalAccounts();
        a1.displayDetails(a1);

        System.out.print("\n\n");

        Book.displayLibraryName();
        Book b1 = new Book("Java", "James", "ISBN-123");
        b1.displayDetails(b1);

        System.out.print("\n\n");

        Employee e1 = new Employee("Asha", 12, "Developer");
        Employee.displayTotalEmployees();
        e1.displayDetails(e1);

        System.out.print("\n\n");

        Product.updateDiscount(15);
        Product p1 = new Product("Mouse", 800, 5, "P-1");
        p1.processDetails(p1);

        System.out.print("\n\n");

        Student.displayTotalStudents();
        Student s1 = new Student("Neel", 7, "A");
        s1.displayStudent(s1);

        System.out.print("\n\n");

        Vehicle.updateRegistrationFee(750);
        Vehicle v1 = new Vehicle("Sara", "Bike", "REG-77");
        v1.displayRegistration(v1);

        System.out.print("\n\n");

        Patient.getTotalPatients();
        Patient pt1 = new Patient("Tom", 40, "Fever", "PAT-9");
        pt1.displayDetails(pt1);
    }
}

