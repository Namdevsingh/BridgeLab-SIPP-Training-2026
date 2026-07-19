import java.util.*;

public class ThrowVsThrowsCalculateInterest {
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) throw new IllegalArgumentException();
        return (amount * rate * years) / 100.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double amount = input.nextDouble();
        double rate = input.nextDouble();
        int years = input.nextInt();

        try {
            double interest = calculateInterest(amount, rate, years);
            System.out.print(interest);
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid input: Amount and rate must be positive");
        }
    }
}

