import java.util.*;

public class SumNaturalWithForCompare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if (n < 0) {
            System.out.print("The number " + n + " is not a natural number");
            return;
        }

        long formula = (long) n * (n + 1) / 2;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.print(
                "The sum of " + n + " natural numbers is " + formula + "\n" +
                "The sum computed using for loop is " + sum + "\n" +
                "Both computations were correct: " + (formula == sum)
        );
    }
}

