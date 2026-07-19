class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        double balance = 5000;
        double withdrawalRequest = 8000;

        try {
            withdraw(balance, withdrawalRequest);
        } catch (InsufficientBalanceException e) {
            System.out.print(e.getMessage());
        }
    }

    static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        double newBalance = balance - amount;
        System.out.print("Withdrawal successful, new balance: " + newBalance);
    }
}

