import java.util.*;

public class SumNaturalRecursionCompare {
    static long sumRecursive(int n) {
        if (n <= 0) return 0;
        return n + sumRecursive(n - 1);
    }

    static long sumFormula(int n) {
        return (long) n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if (n < 0) {
            System.out.print("Invalid");
            return;
        }

        long recursive = sumRecursive(n);
        long formula = sumFormula(n);

        boolean correct = recursive == formula;

        System.out.print("RecursiveSum=" + recursive + "\nFormulaSum=" + formula + "\nCorrect=" + correct);
    }
}

