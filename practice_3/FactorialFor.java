import java.util.*;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number < 0) {
            System.out.print("The number is not a natural number");
            return;
        }

        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.print(factorial);
    }
}

