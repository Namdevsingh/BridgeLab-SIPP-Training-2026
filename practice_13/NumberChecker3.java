import java.util.*;

public class NumberChecker3 {
    static int countDigits(int number) {
        int n = Math.abs(number);
        if (n == 0) return 1;
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    static int[] storeDigits(int number) {
        int n = Math.abs(number);
        int count = countDigits(number);
        int[] digits = new int[count];
        int i = count - 1;
        if (n == 0) {
            digits[0] = 0;
            return digits;
        }
        while (n != 0) {
            digits[i] = n % 10;
            n /= 10;
            i--;
        }
        return digits;
    }

    static int[] reverseDigits(int[] digits) {
        int[] rev = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            rev[i] = digits[digits.length - 1 - i];
        }
        return rev;
    }

    static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int d : digits) {
            if (d != 0) return true;
        }
        return false;
    }

    static boolean isPalindromeDigits(int number) {
        int[] digits = storeDigits(number);
        int[] rev = reverseDigits(digits);
        return arraysEqual(digits, rev);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int[] digits = storeDigits(number);
        boolean palindrome = isPalindromeDigits(number);
        boolean duck = isDuckNumber(number);

        System.out.print("Palindrome=" + palindrome + " Duck=" + duck);
    }
}

