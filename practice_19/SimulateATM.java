public class SimulateATM {
    static class BankAccount {
        String accountHolder;
        int accountNumber;
        double balance;

        BankAccount(String accountHolder, int accountNumber, double balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        void deposit(double amount) {
            if (amount > 0) balance += amount;
        }

        boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        void displayBalance() {
            System.out.print("Current balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Rahul", 12345, 5000);
        acc.deposit(2500);
        acc.withdraw(8000);
        acc.displayBalance();
    }
}

