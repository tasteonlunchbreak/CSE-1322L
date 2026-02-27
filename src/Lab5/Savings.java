package Lab5;
public class Savings extends Account { 
    private int numberOfDeposits = 0;

    public Savings(double balance) {
        super(balance);
    }

    @Override
    public double withdraw(double amount) {
        double newBalance = super.withdraw(amount);

        if (newBalance < 500) {
            System.out.println("Charging a fee of $10 because you are below $500");
            newBalance = super.withdraw(10);
        }

        return newBalance;
    }
    @Override
    public double deposit(double amount) {
        double newBalance = super.deposit(amount);
        numberOfDeposits++;

        System.out.println("This is deposit " + numberOfDeposits + " to this account");

        if (numberOfDeposits > 5) {
            System.out.println("Charging a fee of $10");
            newBalance = super.withdraw(10);
        }
        return newBalance;
    }
    public double addInterest() {
        double interest = getAccountBalance() * 0.015;
        System.out.println("Customer has earned $" + interest + " in interest");
        return super.deposit(interest);
    }

    @Override
    public String toString() {
        return "Savings Account #" + getAccountNumber() +   ", balance: $" +getAccountBalance();
    }
}