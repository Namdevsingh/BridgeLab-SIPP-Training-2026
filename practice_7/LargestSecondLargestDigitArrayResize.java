import java.util.*;

public class LargestSecondLargestDigitArrayResize {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        int n = Math.abs(number);

        if (n == 0) {
            System.out.print("Largest: 0 Second largest: 0");
            return;
        }

        while (n != 0) {
            if (index == maxDigit) {
                int newSize = maxDigit + 10;
                int[] temp = new int[newSize];
                for (int i = 0; i < maxDigit; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
                maxDigit = newSize;
            }
            digits[index] = n % 10;
            index++;
            n = n / 10;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            int d = digits[i];
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }

        System.out.print("Largest: " + largest + " Second largest: " + secondLargest);
    }
}

