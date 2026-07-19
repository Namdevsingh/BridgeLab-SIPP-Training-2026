import java.util.*;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    static double totalBill(int itemsCount, double rate) {
        return itemsCount * rate;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] patientIds = new int[3];
        for (int i = 0; i < 3; i++) patientIds[i] = input.nextInt();

        int patientIndex = input.nextInt();
        int itemsCount = input.nextInt();
        double rate = input.nextDouble();
        double payment = input.nextDouble();

        try {
            double bill;
            try {
                if (itemsCount == 0) {
                    int x = 10 / 0;
                }
                bill = totalBill(itemsCount, rate);
            } catch (ArithmeticException e) {
                System.out.print("Invalid billing items: division by zero");
                return;
            }

            double remaining;
            try {
                String s = "";
                s.charAt(100);
            } catch (StringIndexOutOfBoundsException e) {
            }

            try {
                int id = patientIds[patientIndex];
                if (payment < bill) {
                    throw new InsufficientFundsException("InsufficientFundsException: Payment failed");
                }
                remaining = bill - payment;
                System.out.print("Patient " + id + " bill paid successfully. Balance: " + remaining);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Invalid patient index!");
            }

        } catch (InsufficientFundsException e) {
            System.out.print(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.print("Bad input");
        }
    }
}

