import java.util.*;

public class ReverseNumberUsingDigitArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int n = Math.abs(number);

        int count = 0;
        int temp = n;
        if (temp == 0) count = 1;
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        int[] digits = new int[count];
        int idx = 0;
        if (n == 0) {
            digits[0] = 0;
        } else {
            while (n != 0) {
                digits[idx] = n % 10;
                idx++;
                n = n / 10;
            }
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.print(digits[i]);
            if (i != 0) System.out.print(" ");
        }
    }
}

