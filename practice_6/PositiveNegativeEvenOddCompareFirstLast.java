import java.util.*;

public class PositiveNegativeEvenOddCompareFirstLast {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (n > 0) {
                if (n % 2 == 0) {
                    System.out.print(n + " is positive and even");
                } else {
                    System.out.print(n + " is positive and odd");
                }
            } else if (n < 0) {
                System.out.print(n + " is negative");
            } else {
                System.out.print(n + " is zero");
            }
            if (i != numbers.length - 1) System.out.print("\n");
        }

        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            System.out.print("\nFirst and last elements are equal");
        } else if (first > last) {
            System.out.print("\nFirst element is greater than last element");
        } else {
            System.out.print("\nFirst element is less than last element");
        }
    }
}

