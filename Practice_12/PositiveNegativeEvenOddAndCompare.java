import java.util.*;

public class PositiveNegativeEvenOddAndCompare {
    static int checkSign(int n) {
        if (n > 0) return 1;
        if (n < 0) return -1;
        return 0;
    }

    static int checkEvenOdd(int n) {
        return n % 2 == 0 ? 1 : 0;
    }

    static int compare(int a, int b) {
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < nums.length; i++) nums[i] = input.nextInt();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sign = checkSign(n);

            if (sign == 1) {
                int even = checkEvenOdd(n);
                if (even == 1) System.out.print(n + " is positive and even");
                else System.out.print(n + " is positive and odd");
            } else if (sign == -1) {
                System.out.print(n + " is negative");
            } else {
                System.out.print(n + " is zero");
            }

            if (i != nums.length - 1) System.out.print("\n");
        }

        int first = nums[0];
        int last = nums[nums.length - 1];
        int cmp = compare(first, last);

        if (cmp == 0) System.out.print("\nEqual");
        else if (cmp == 1) System.out.print("\nGreater");
        else System.out.print("\nLess");
    }
}

