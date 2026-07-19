import java.util.*;

public class FactorsArrayStats {
    static int[] factorsOf(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    static long sumOfFactors(int[] factors) {
        long sum = 0;
        for (int v : factors) sum += v;
        return sum;
    }

    static long productOfFactors(int[] factors) {
        long product = 1;
        for (int v : factors) product *= v;
        return product;
    }

    static double sumOfSquareOfFactors(int[] factors) {
        double sum = 0;
        for (int v : factors) sum += Math.pow(v, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int[] factors = factorsOf(number);

        long sum = sumOfFactors(factors);
        long product = productOfFactors(factors);
        double sumSquares = sumOfSquareOfFactors(factors);

        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i]);
            if (i != factors.length - 1) System.out.print(" ");
        }
        System.out.print("\nSum=" + sum + "\nProduct=" + product + "\nSumSquares=" + sumSquares);
    }
}

