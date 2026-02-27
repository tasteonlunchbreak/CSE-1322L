package Lab5;
public class Account {
    private int accountNumber;
    private static int nextNumber = 10001;
    private double accountBalance;

    public Account() {
        accountNumber = nextNumber;
        nextNumber++;
        accountBalance = 0;
    }

    public Account(double balance) {
        accountNumber = nextNumber;
        nextNumber++;
        accountBalance = balance;
    }

    public double withdraw(double amount) {
        accountBalance -= amount;
        return accountBalance;
    }

    public double deposit(double amount) {
        accountBalance += amount;
        return accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account #" + accountNumber + ", balance $" + accountBalance;
    }
}

