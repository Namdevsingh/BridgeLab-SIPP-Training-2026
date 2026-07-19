import java.util.*;

public class OddEvenBetween1ToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number < 1) {
            System.out.print("Invalid input");
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " is even");
            } else {
                System.out.print(i + " is odd");
            }
            if (i != number) {
                System.out.print("\n");
            }
        }
    }
}

