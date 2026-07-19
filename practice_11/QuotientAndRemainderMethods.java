import java.util.*;

public class QuotientAndRemainderMethods {
    static int quotient(int a, int b) {
        return a / b;
    }

    static int remainder(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int q = quotient(a, b);
        int r = remainder(a, b);

        System.out.print("Quotient: " + q + " and Remainder: " + r);
    }
}

