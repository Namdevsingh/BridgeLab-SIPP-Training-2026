class BankAccountStaticDepositWithdrawTransactions {

    static class BankAccount {
        static int totalAccounts = 0;

        final int accountNumber;
        String holder;
        double balance;

        BankAccount(String holder, int accountNumber, double balance) {
            this.holder = holder;
            this.accountNumber = accountNumber;
            this.balance = balance;
            totalAccounts++;
        }

        void deposit(double amount) {
            if (amount > 0) balance += amount;
        }

        void withdraw(double amount) {
            if (amount > 0) {
                if (amount <= balance) balance -= amount;
            }
        }

        String getStatement() {
            return "Account No: " + accountNumber + "\nHolder: " + holder + "\nBalance: " + balance;
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Rahul", 1001, 5000);
        BankAccount a2 = new BankAccount("Anita", 1002, 3000);
        BankAccount a3 = new BankAccount("Kiran", 1003, 7000);

        for (int i = 0; i < 5; i++) {
            a1.deposit(200);
            a1.withdraw(150);
            a2.deposit(300);
            a2.withdraw(400);
            a3.deposit(500);
            a3.withdraw(250);
        }

        System.out.print(a1.getStatement() + "\n\n" + a2.getStatement() + "\n\n" + a3.getStatement() + "\n\nTotal Accounts: " + BankAccount.totalAccounts);
    }
}

