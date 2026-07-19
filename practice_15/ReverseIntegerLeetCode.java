import java.util.*;

public class ReverseIntegerLeetCode {
    static int reverse(int x, int rev) {
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.print(reverse(x, 0));
    }
}

