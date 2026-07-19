import java.util.*;

public class NumberChecker2 {
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

    static int sumDigits(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    static double sumSquaresDigits(int number) {
        int[] digits = storeDigits(number);
        double sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    static boolean isHarshadNumber(int number) {
        if (number == 0) return false;
        int digitSum = sumDigits(number);
        return digitSum != 0 && (number % digitSum == 0);
    }

    static String[][] digitFrequencies(int number) {
        int[] digits = storeDigits(number);
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        int unique = 0;
        for (int i = 0; i < 10; i++) if (freq[i] > 0) unique++;

        String[][] table = new String[unique][2];
        int idx = 0;
        for (int d = 0; d < 10; d++) {
            if (freq[d] > 0) {
                table[idx][0] = String.valueOf(d);
                table[idx][1] = String.valueOf(freq[d]);
                idx++;
            }
        }
        return table;
    }

    static void displayTable(String[][] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i][0] + "\t" + t[i][1]);
            if (i != t.length - 1) System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int digitSum = sumDigits(number);
        double squares = sumSquaresDigits(number);
        boolean harshad = isHarshadNumber(number);

        String[][] freqTable = digitFrequencies(number);

        System.out.print("SumDigits=" + digitSum + " SumSquares=" + squares + " Harshad=" + harshad + "\n");
        displayTable(freqTable);
    }
}

