import java.util.*;

public class FactorialRecursive {
    static long factorial(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long fact = factorial(n);
        System.out.print(fact);
    }
}

