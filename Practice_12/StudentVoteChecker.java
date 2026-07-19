import java.util.*;

public class StudentVoteChecker {
    static boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = input.nextInt();
        }

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0) {
                System.out.print("Invalid age");
            } else if (canStudentVote(age)) {
                System.out.print("The student with the age " + age + " can vote.");
            } else {
                System.out.print("The student with the age " + age + " cannot vote.");
            }
            if (i != ages.length - 1) System.out.print("\n");
        }
    }
}

