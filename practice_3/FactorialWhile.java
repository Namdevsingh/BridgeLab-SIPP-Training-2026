import java.util.*;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number < 0) {
            System.out.print("The number is not a natural number");
            return;
        }

        long factorial = 1;
        int i = 1;
        while (i <= number) {
            factorial *= i;
            i++;
        }

        System.out.print(factorial);
    }
}

