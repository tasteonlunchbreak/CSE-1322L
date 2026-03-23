import java.util.Scanner;

public class Lab1 {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        System.out.println("[Budgeting System]");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Hello " + name + ". Please enter your monthly salary: ");
        double salary = input.nextDouble();
        System.out.println();

        double yearly_salary = salary * 12;

        System.out.print("What is the total amount of your loan? ");
        double loan_principal = input.nextDouble();
        System.out.print("What is interest rate of your loan? ");
        double loan_interest = (input.nextDouble()) / 100;
        double new_principal = loan_principal * Math.pow((1 + (loan_interest / 12)), 12);
        System.out.println();

        System.out.println("Your  yearly salary is $" + String.format("%.2f", yearly_salary));
        System.out.println("In 12 months, your loan's principal will be $" + String.format("%.5f", new_principal));
        System.out.println();

        System.out.print("At the end of the year, you will have paid off your debt: ");
        System.out.println(yearly_salary >= new_principal);
        System.out.print("At the end of the year, your will still have some debt left: ");
        System.out.println(yearly_salary < new_principal);
        System.out.print("At the end of the year, you will have $" + String.format("%.2f", (yearly_salary - new_principal)) + " of your salary left");
        System.out.println();

        System.out.println();
        System.out.println("The government is offering loan relief for persons 25 and under, and for those 65 and over.");
        System.out.print("What is your age? ");
        int age = input.nextInt();
        boolean eligible_for_relief = (age <= 25) || (age >= 65);
        System.out.println("The relief is $10000. You are eligible for the relief: " + eligible_for_relief);
        boolean loan_paid_off = (yearly_salary >= new_principal) || (eligible_for_relief && ((yearly_salary + 10000) >= new_principal));
        System.out.println("With or without relief, you will be able to pay your loan in full: " + loan_paid_off);
        
        input.close();
    }
}
