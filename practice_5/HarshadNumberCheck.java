import java.util.*;

public class HarshadNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int sum = 0;
        int temp = Math.abs(number);

        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            temp = temp / 10;
        }

        if (sum != 0 && number % sum == 0) {
            System.out.print("Harshad Number");
        } else {
            System.out.print("Not a Harshad Number");
        }
    }
}

