import java.util.*;

public class PowerCalculationNoLoops {
    static double power(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (exponent < 0) return 1.0 / power(base, -exponent);
        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double base = input.nextDouble();
        int exponent = input.nextInt();
        System.out.print(power(base, exponent));
    }
}

