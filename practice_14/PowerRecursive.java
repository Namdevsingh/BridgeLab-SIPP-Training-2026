import java.util.*;

public class PowerRecursive {
    static long power(long x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (n == 1) return x;
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long x = input.nextLong();
        int n = input.nextInt();
        System.out.print(power(x, n));
    }
}

