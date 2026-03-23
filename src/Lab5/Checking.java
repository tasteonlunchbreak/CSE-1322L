package Lab5;
public class Checking extends Account {
    public Checking(double balance) {
        super(balance);
    }
    @Override
    public double withdraw(double amount) {
        double newBalance = super.withdraw(amount);

        if (newBalance < 0) {
            System.out.println("Charging an overdraft free of $20 because account is below $0");
            newBalance = super.withdraw(20);
        }

        return newBalance;
    }
    
    @Override
    public String toString() {
        return "Checking Account #" + getAccountNumber() + ", balance: $" + getAccountBalance();
    }
    
}
