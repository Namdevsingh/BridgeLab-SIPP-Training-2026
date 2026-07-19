import java.util.*;

public class PowerOfFourLeetCode {
    static boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(isPowerOfFour(n));
    }
}

