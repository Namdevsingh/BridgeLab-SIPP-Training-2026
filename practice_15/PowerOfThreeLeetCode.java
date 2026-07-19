import java.util.*;

public class PowerOfThreeLeetCode {
    static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        return (n % 3 == 0) && isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(isPowerOfThree(n));
    }
}

