import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Checking checking = new Checking(0);
        Savings savings = new Savings(500);
        
        System.out.println("[Banking System]");
        int option = 0;

        while (option != 8) {
            System.out.println("1. Withdraw from Checking");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Deposit to Checking");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Balance of Checking");
            System.out.println("6. Balance of Savings");
            System.out.println("7. Award Interest to Savings");
            System.out.println("8. Quit");
            System.out.print("Select option: ");
            option = input.nextInt();

            switch(option) {
                case 1:
                    System.out.print("How much would you like to withdraw from Checking? $");
                    double withdrawChecking = input.nextDouble();
                    double newCheckingBalance = checking.withdraw(withdrawChecking);
                    System.out.printf("Current balance of Checking is $%.2f\n", newCheckingBalance);
                    break;
                case 2:
                    System.out.print("How much would you like to withdraw from Savings? $");
                    double withdrawSavings = input.nextDouble();
                    double newSavingsBalance = savings.withdraw(withdrawSavings);
                    System.out.printf("Current balance of Savings is $%.2f\n", newSavingsBalance);
                    break;
                case 3:
                    System.out.print("How much would you like to deposit to Checking? $");
                    double depositChecking = input.nextDouble();
                    double checkingBalance = checking.deposit(depositChecking);
                    System.out.printf("Current balance of Checking is $%.2f\n", checkingBalance);
                    break;
                case 4:
                    System.out.print("How much would you like to deposit to Savings? $");
                    double depositSavings = input.nextDouble();
                    double savingsBalance = savings.deposit(depositSavings);
                    System.out.printf("Current balance of Savings is $%.2f\n", savingsBalance);
                    break;
                case 5:
                    System.out.println(checking.toString());
                    break;
                case 6:
                    System.out.println(savings.toString());
                case 7:
                    double interestBalance = savings.addInterest();
                    System.out.printf("Current balance of Savings is $%.2f\n", interestBalance);
                    break;
                case 8:
                    System.out.println("Shutting off...");
                    break;  
                default:
                    System.out.println("\nInvalid option.");
                    break;
        }
        System.out.println();
    }
    input.close();
    }
}
