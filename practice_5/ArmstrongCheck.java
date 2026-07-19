import java.util.*;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum = sum + digit * digit * digit;
            originalNumber = originalNumber / 10;
        }

        if (sum == number) {
            System.out.print(number + " is an Armstrong number");
        } else {
            System.out.print(number + " is not an Armstrong number");
        }
    }
}

