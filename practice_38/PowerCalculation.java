import java.util.*;

public class PowerCalculation {
    static double power(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (exponent < 0) return 1.0 / power(base, -exponent);
        double result = 1.0;
        for (int i = 0; i < exponent; i++) result *= base;
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double base = input.nextDouble();
        int exponent = input.nextInt();
        System.out.print(power(base, exponent));
    }
}

