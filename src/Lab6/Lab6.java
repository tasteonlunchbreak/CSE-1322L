package Lab6;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FindFib formula = new FibFormula();
        FindFib iteration = new FibIteration();

        System.out.print("Find which position in the Fibonacci Sequence? ");
        int n = input.nextInt();

        int iterate = iteration.calculateFib(n);
        int formulate = formula.calculateFib(n);

        System.out.println("Fib of "+ n +" using iteration is "+ iterate);
        System.out.println("Fib of "+ n +" using Binet's Formula is "+ formulate);
        System.out.println("Program complete.");

        input.close();
    }
}