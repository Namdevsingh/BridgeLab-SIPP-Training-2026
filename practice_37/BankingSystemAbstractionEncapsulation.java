public class BankingSystemAbstractionEncapsulation {

    public static abstract class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount <= 0) return;
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount <= 0) return;
            if (amount <= balance) balance -= amount;
        }

        public void displayAccountDetails() {
            System.out.println("AccountNumber: " + accountNumber);
            System.out.println("HolderName: " + holderName);
            System.out.println("Balance: " + balance);
        }

        public abstract double calculateInterest();
    }

    public static class SavingsAccount extends BankAccount {
        private double interestRate;

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public double calculateInterest() {
            return getBalance() * interestRate / 100.0;
        }
    }

    public static class CurrentAccount extends BankAccount {
        private double monthlyBonusRate;

        public double getMonthlyBonusRate() {
            return monthlyBonusRate;
        }

        public void setMonthlyBonusRate(double monthlyBonusRate) {
            this.monthlyBonusRate = monthlyBonusRate;
        }

        public double calculateInterest() {
            return getBalance() * monthlyBonusRate / 100.0;
        }
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount();
        sa.setAccountNumber("SAV-123");
        sa.setHolderName("Meera");
        sa.setBalance(10000);
        sa.setInterestRate(5);

        CurrentAccount ca = new CurrentAccount();
        ca.setAccountNumber("CUR-777");
        ca.setHolderName("Arjun");
        ca.setBalance(20000);
        ca.setMonthlyBonusRate(1.5);

        sa.deposit(2500);
        sa.withdraw(4000);

        ca.deposit(5000);
        ca.withdraw(2000);

        System.out.println("--- Savings Account ---");
        sa.displayAccountDetails();
        System.out.println("Calculated Interest: " + sa.calculateInterest());

        System.out.println("--- Current Account ---");
        ca.displayAccountDetails();
        System.out.println("Calculated Interest: " + ca.calculateInterest());
    }
}

