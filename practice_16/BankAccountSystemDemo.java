import java.util.*;

public class BankAccountSystemDemo {
    static class BankAccount {
        double balance;

        BankAccount(double balance) {
            this.balance = balance;
        }

        void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
            if (amount < 0) throw new IllegalArgumentException();
            if (amount > balance) throw new InsufficientBalanceException("Insufficient balance!");
            balance -= amount;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double startingBalance = input.nextDouble();
        double amount = input.nextDouble();

        BankAccount account = new BankAccount(startingBalance);

        try {
            account.withdraw(amount);
            System.out.print("Withdrawal successful, new balance: " + account.balance);
        } catch (InsufficientBalanceException e) {
            System.out.print(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid amount!");
        }
    }
}

