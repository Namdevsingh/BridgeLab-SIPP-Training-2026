import java.util.*;

public class NumberChecker1 {
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

    static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int d : digits) {
            if (d != 0) return true;
        }
        return false;
    }

    static boolean isArmstrongNumber(int number) {
        int[] digits = storeDigits(number);
        int power = digits.length;
        long sum = 0;
        for (int d : digits) {
            sum += Math.round(Math.pow(d, power));
        }
        return sum == number;
    }

    static int[] largestAndSecondLargest(int number) {
        int[] digits = storeDigits(number);
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    static int[] smallestAndSecondSmallest(int number) {
        int[] digits = storeDigits(number);
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int digitCount = countDigits(number);
        boolean duck = isDuckNumber(number);
        boolean armstrong = isArmstrongNumber(number);

        int[] l = largestAndSecondLargest(number);
        int[] s = smallestAndSecondSmallest(number);

        System.out.print("DigitsCount=" + digitCount + " Duck=" + duck + " Armstrong=" + armstrong + " Largest=" + l[0] + " SecondLargest=" + l[1] + " Smallest=" + s[0] + " SecondSmallest=" + s[1]);
    }
}

