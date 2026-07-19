import java.util.*;

public class MarksToGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double physics = input.nextDouble();
        double chemistry = input.nextDouble();
        double maths = input.nextDouble();

        double total = physics + chemistry + maths;
        double percent = (total / 3.0);

        String grade;
        String remarks;

        if (percent >= 90) {
            grade = "A";
            remarks = "Excellent";
        } else if (percent >= 80) {
            grade = "B";
            remarks = "Very Good";
        } else if (percent >= 70) {
            grade = "C";
            remarks = "Good";
        } else if (percent >= 60) {
            grade = "D";
            remarks = "Average";
        } else if (percent >= 50) {
            grade = "E";
            remarks = "Pass";
        } else {
            grade = "F";
            remarks = "Fail";
        }

        System.out.print("Average Mark is " + percent + " and Grade is " + grade + " and Remarks are " + remarks);
    }
}

