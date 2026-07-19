public class EmployeePayrollSystemAbstractionEncapsulation {

    public static abstract class Employee {
        private int employeeId;
        private String employeeName;

        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public abstract double calculateSalary();

        public void displayEmployeeInfo() {
            System.out.println("EmployeeId: " + employeeId);
            System.out.println("EmployeeName: " + employeeName);
            System.out.println("Salary: " + calculateSalary());
        }
    }

    public static class FullTimeEmployee extends Employee {
        private double monthlySalary;

        public double getMonthlySalary() {
            return monthlySalary;
        }

        public void setMonthlySalary(double monthlySalary) {
            this.monthlySalary = monthlySalary;
        }

        public double calculateSalary() {
            return monthlySalary;
        }
    }

    public static class PartTimeEmployee extends Employee {
        private double hoursWorked;
        private double hourlyRate;

        public double getHoursWorked() {
            return hoursWorked;
        }

        public void setHoursWorked(double hoursWorked) {
            this.hoursWorked = hoursWorked;
        }

        public double getHourlyRate() {
            return hourlyRate;
        }

        public void setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
        }

        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    public static void main(String[] args) {
        FullTimeEmployee ft = new FullTimeEmployee();
        ft.setEmployeeId(101);
        ft.setEmployeeName("Ravi");
        ft.setMonthlySalary(50000);

        PartTimeEmployee pt = new PartTimeEmployee();
        pt.setEmployeeId(202);
        pt.setEmployeeName("Anya");
        pt.setHoursWorked(120);
        pt.setHourlyRate(400);

        System.out.println("--- Full Time Employee ---");
        ft.displayEmployeeInfo();
        System.out.println("--- Part Time Employee ---");
        pt.displayEmployeeInfo();
    }
}

