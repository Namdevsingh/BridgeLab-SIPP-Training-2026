public class EmployeeDetails {
    static class Employee {
        String name;
        int id;
        double salary;

        Employee(String name, int id, double salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        void displayDetails() {
            System.out.print("Employee Details\nName: " + name + "\nID: " + id + "\nSalary: " + salary);
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee("John", 101, 50000);
        e.displayDetails();
    }
}

