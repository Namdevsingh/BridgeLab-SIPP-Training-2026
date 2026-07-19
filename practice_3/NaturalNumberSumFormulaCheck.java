import java.util.*;

public class NaturalNumberSumFormulaCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number >= 0) {
            long n = number;
            long sumByFormula = n * (n + 1) / 2;
            long sumByLoop = 0;
            for (long i = 1; i <= n; i++) {
                sumByLoop += i;
            }
            boolean correct = sumByFormula == sumByLoop;
            System.out.print("The sum of " + number + " natural numbers is " + sumByFormula + "\n" +
                    "The sum computed by formula matches: " + correct);
        } else {
            System.out.print("The number " + number + " is not a natural number");
        }
    }
}

