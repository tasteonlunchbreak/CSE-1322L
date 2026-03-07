import java.util.Scanner;

public class Lab7 {
    public static int recursiveMultiply(int num1, int num2) {
        if (num2 == 0) {
            return 0;
        } 
        else if (num2 > 0) {
            return num1 + recursiveMultiply(num1, num2 - 1);
        }
        else {
            return 0;
        }
    }
    public static int recursiveDivision(int num1, int num2) {
        if (num2 == 0) {
            return -1;
        }
        else if (num1 < num2) {
            return 0;
        } 
        else {
            return 1 + recursiveDivision(num1 - num2, num2);
        }
    }
    public static int recursiveRemainder(int num1, int num2) {
        if (num2 == 0) {
            return -1;
        }
        else if (num1 < num2) {
            return num1;
        } 
        else {
            return recursiveRemainder(num1 - num2, num2);
        }
    }
    public static String recursiveEcho(String sentence, int numTimes) {
        if (numTimes <= 0) {
            return "";
        } else {
            return sentence + recursiveEcho(sentence, numTimes - 1);
        }
    }
    public static boolean recursiveReverse(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        
        if (word1.length() == 0 && word2.length() == 0) {
            return true;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.charAt(0) != word2.charAt(word2.length() - 1)) {
            return false;
        }
        return recursiveReverse(word1.substring(1), word2.substring(0, word2.length() - 1));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int options = 0;

        while (options != 6) {
            System.out.println("1. Multiply 2 numbers");
            System.out.println("2. Divide 2 numbers");
            System.out.println("3. Mod 2 numbers");
            System.out.println("4. Echo sentence");
            System.out.println("5. Determine if reverse");
            System.out.println("6. Quit");
            System.out.print("Enter option: ");
            options = input.nextInt();
            input.nextLine();

            switch(options) {
                case 1:
                    System.out.print("Enter the first number: ");
                    int firstNum = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter the second number: ");
                    int secondNum = input.nextInt();
                    input.nextLine();
                    int result = recursiveMultiply(firstNum, secondNum);
                    System.out.println("Your product is " + result + "\n");
                    break;
                case 2:
                    System.out.print("Enter the first number: ");
                    firstNum = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter the second number: ");
                    secondNum = input.nextInt();
                    input.nextLine();
                    result = recursiveDivision(firstNum, secondNum);
                    System.out.println("Your quotient is " + result + "\n");
                    break;
                case 3:
                    System.out.print("Enter the first number: ");
                    firstNum = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter the second number: ");
                    secondNum = input.nextInt();
                    input.nextLine();
                    result = recursiveRemainder(firstNum, secondNum);
                    System.out.println("Your modulus is " + result + "\n");
                    break;
                case 4:
                    System.out.print("Enter your sentence: ");
                    String userSentence = input.nextLine();
                    System.out.print("Repeat how many times? ");
                    int numRepeats = input.nextInt();
                    input.nextLine();
                    String repeatedResult = recursiveEcho(userSentence, numRepeats);
                    System.out.println("Your sentence repeated " + numRepeats + " times is");
                    System.out.println(repeatedResult);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter your sentence: ");
                    userSentence = input.nextLine();
                    System.out.print("Enter another sentence: ");
                    String anotherSentence = input.nextLine();
                    boolean reverseResult = recursiveReverse(userSentence, anotherSentence);
                    if (reverseResult) {
                        System.out.println("The sentences are the opposite of each other.\n");
                    } else {
                        System.out.println("The sentences are NOT the opposite of each other.\n");
                    }
                    break;
                case 6:
                    System.out.println("Shutting off...");
                    break;
                default:
                    System.out.println("\nInvalid option. Try again.\n");
                    break;
            }
        }
        input.close();
    }
    
}