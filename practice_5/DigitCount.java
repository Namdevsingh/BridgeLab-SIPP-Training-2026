import java.util.*;

public class DigitCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number == 0) {
            System.out.print(1);
            return;
        }

        int count = 0;
        number = Math.abs(number);

        while (number != 0) {
            number = number / 10;
            count++;
        }

        System.out.print(count);
    }
}

