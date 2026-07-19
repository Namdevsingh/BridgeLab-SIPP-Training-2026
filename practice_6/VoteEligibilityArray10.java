import java.util.*;

public class VoteEligibilityArray10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = input.nextInt();
        }

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                System.out.print("Invalid age");
            } else if (ages[i] >= 18) {
                System.out.print("The student with the age " + ages[i] + " can vote.");
            } else {
                System.out.print("The student with the age " + ages[i] + " cannot vote.");
            }
            if (i != ages.length - 1) System.out.print("\n");
        }
    }
}

