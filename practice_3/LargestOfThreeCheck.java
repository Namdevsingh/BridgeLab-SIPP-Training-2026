import java.util.*;

public class LargestOfThreeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();

        boolean firstLargest = number1 >= number2 && number1 >= number3;
        boolean secondLargest = number2 >= number1 && number2 >= number3;
        boolean thirdLargest = number3 >= number1 && number3 >= number2;

        System.out.print(
                "Is the first number the largest? " + firstLargest + "\n" +
                "Is the second number the largest? " + secondLargest + "\n" +
                "Is the third number the largest? " + thirdLargest
        );
    }
}

