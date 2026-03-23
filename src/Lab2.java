import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int options;

        do {
            System.out.println("1. Count from a number to another");
            System.out.println("2. Determine largest number");
            System.out.println("3. Type in word");
            System.out.println("4. Quit");
            System.out.print("Enter option: ");
            options = input.nextInt();

            switch(options){
                case 1:
                    System.out.print("\nEnter the start point: ");
                    int start_point = input.nextInt();
                    System.out.print("Enter the end point: ");
                    int end_point = input.nextInt();
                    System.out.println("Counting from " + start_point + " to " + end_point + "...");

                    if (start_point == end_point) {
                        System.out.println("Start and end are the same!");
                    } else if (start_point < end_point) {
                        for (int i = start_point; i <= end_point; i++) {
                            System.out.println(i);
                        }
                    } else {
                        for (int i = start_point; i >= end_point; i--) {
                            System.out.println(i);
                        }
                    }
                    System.out.println("Done counting.\n");
                    break;
                case 2: 
                    int largest_number = 0;
                    System.out.println("\nThis option will display the largest number entered. Enter 0 when done.");
                    int new_number;

                    do {
                        System.out.print("Enter a number (current largest is "+ largest_number + "): ");
                        new_number = input.nextInt();
                        if (new_number > largest_number) {
                            largest_number = new_number;
                        }
                    } while (new_number != 0);
                    System.out.println("The largest number entered was " + largest_number +"\n");
                    break;
                case 3:
                    input.nextLine();
                    String input_word;
                    System.out.print("\nType in the word 'Computer': ");
                    input_word = input.nextLine();

                    while (!input_word.equals("Computer")) {
                        System.out.print("Incorrect. You must type 'Computer': ");
                        input_word = input.nextLine();
                    }
                    System.out.println("Correct!\n");
                    break;
                case 4:
                    System.out.println("\nShutting off...");
                    break;
                default:
                    System.out.println("\nInvalid option. Try again.\n");
                    break;
            }
        } 
        while (options != 4);
        input.close();
    }
}