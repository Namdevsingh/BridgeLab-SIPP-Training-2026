import java.util.*;

public class SumFirstNRecursive {
    static long sumFirstN(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return n + sumFirstN(n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(sumFirstN(n));
    }
}

