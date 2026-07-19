public class StudentReport {
    static class Student {
        String name;
        int rollNumber;
        double marks;

        Student(String name, int rollNumber, double marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        String grade() {
            if (marks >= 90) return "A";
            if (marks >= 80) return "B";
            if (marks >= 70) return "C";
            if (marks >= 60) return "D";
            return "F";
        }

        void displayDetails() {
            System.out.print("Name: " + name + "\nRoll Number: " + rollNumber + "\nMarks: " + marks + "\nGrade: " + grade());
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Alice", 7, 86);
        s.displayDetails();
    }
}

