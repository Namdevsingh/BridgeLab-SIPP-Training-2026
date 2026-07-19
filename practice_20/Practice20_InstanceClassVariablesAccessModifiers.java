class Practice20_InstanceClassVariablesAccessModifiers {

    static class Product {
        String productName;
        double price;
        static int totalProducts = 0;

        Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
            totalProducts++;
        }

        void displayProductDetails() {
            System.out.print("Product: " + productName + "\nPrice: " + price);
        }

        static void displayTotalProducts() {
            System.out.print("\nTotal Products: " + totalProducts);
        }
    }

    static class Course {
        String courseName;
        int duration;
        double fee;
        static String instituteName = "CodeSchool";

        Course(String courseName, int duration, double fee) {
            this.courseName = courseName;
            this.duration = duration;
            this.fee = fee;
        }

        void displayCourseDetails() {
            System.out.print("Course: " + courseName + "\nDuration: " + duration + " months\nFee: " + fee + "\nInstitute: " + instituteName);
        }

        static void updateInstituteName(String newName) {
            instituteName = newName;
        }
    }

    static class Vehicle {
        String ownerName;
        String vehicleType;
        static double registrationFee = 500;

        Vehicle(String ownerName, String vehicleType) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }

        void displayVehicleDetails() {
            System.out.print("Owner: " + ownerName + "\nVehicle: " + vehicleType + "\nRegistration Fee: " + registrationFee);
        }

        static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
        }
    }

    static class UniversityStudent {
        public int rollNumber;
        protected String name;
        private double cgpa;

        UniversityStudent(int rollNumber, String name, double cgpa) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.cgpa = cgpa;
        }

        public double getCgpa() {
            return cgpa;
        }

        public void setCgpa(double cgpa) {
            this.cgpa = cgpa;
        }

        void display() {
            System.out.print("Roll: " + rollNumber + "\nName: " + name + "\nCGPA: " + cgpa);
        }
    }

    static class PostgraduateStudent extends UniversityStudent {
        PostgraduateStudent(int rollNumber, String name, double cgpa) {
            super(rollNumber, name, cgpa);
        }

        void displayProtectedName() {
            System.out.print("Postgraduate Name (protected): " + name);
        }
    }

    static class AccessBook {
        public String ISBN;
        protected String title;
        private String author;

        AccessBook(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }
    }

    static class EBook extends AccessBook {
        EBook(String ISBN, String title, String author) {
            super(ISBN, title, author);
        }

        void accessISBNAndTitle() {
            System.out.print("ISBN: " + ISBN + "\nTitle: " + title);
        }
    }

    static class BankAccount {
        public int accountNumber;
        protected String accountHolder;
        private double balance;

        BankAccount(int accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) balance -= amount;
        }
    }

    static class SavingsAccount extends BankAccount {
        SavingsAccount(int accountNumber, String accountHolder, double balance) {
            super(accountNumber, accountHolder, balance);
        }

        void accessAccountNumberAndHolder() {
            System.out.print("Account Number: " + accountNumber + "\nHolder: " + accountHolder);
        }
    }

    static class Employee {
        public int employeeID;
        protected String department;
        private double salary;

        Employee(int employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }
    }

    static class Manager extends Employee {
        Manager(int employeeID, String department, double salary) {
            super(employeeID, department, salary);
        }

        void accessEmployeeIDAndDepartment() {
            System.out.print("Employee ID: " + employeeID + "\nDepartment: " + department + "\nSalary: " + getSalary());
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 800);
        p1.displayProductDetails();
        Product.displayTotalProducts();

        System.out.print("\n\n");

        Course c1 = new Course("Java", 3, 15000);
        Course.updateInstituteName("Tech Institute");
        c1.displayCourseDetails();

        System.out.print("\n\n");

        Vehicle v1 = new Vehicle("Sara", "Bike");
        Vehicle.updateRegistrationFee(750);
        v1.displayVehicleDetails();

        System.out.print("\n\n");

        PostgraduateStudent ps = new PostgraduateStudent(10, "Nina", 8.7);
        ps.displayProtectedName();

        System.out.print("\n\n");

        EBook eb = new EBook("ISBN-1", "Algorithms", "CLRS");
        eb.accessISBNAndTitle();

        System.out.print("\n\n");

        SavingsAccount sa = new SavingsAccount(9001, "Arjun", 2000);
        sa.accessAccountNumberAndHolder();

        System.out.print("\n\n");

        Manager m = new Manager(301, "HR", 75000);
        m.accessEmployeeIDAndDepartment();
    }
}

