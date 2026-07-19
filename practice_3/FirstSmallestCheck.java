import java.util.*;

public class FirstSmallestCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();
        boolean isSmallest = number1 <= number2 && number1 <= number3;
        System.out.print("Is the first number the smallest? " + isSmallest);
    }
}

