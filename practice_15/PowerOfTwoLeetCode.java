import java.util.*;

public class PowerOfTwoLeetCode {
    static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return (n % 2 == 0) && isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(isPowerOfTwo(n));
    }
}

