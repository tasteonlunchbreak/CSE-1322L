package Assignment4;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mendec> mendecs = new ArrayList<>();

        int options; 

        System.out.println("[Message Encryptor/Decryptor]");

        do {
            System.out.println("1. Encrypt message");
            System.out.println("2. Decrypt message");
            System.out.println("3. Add mendec");
            System.out.println("4. Show mendecs");
            System.out.println("5. Describe mendec");
            System.out.println("6. Remove mendec");
            System.out.println("0. Quit");
            System.out.print("Enter option: ");
            options = input.nextInt();
            input.nextLine();

            switch (options) {
                case 1: {
                    System.out.print("\nEnter mendec ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    Mendec m = findById(mendecs, id);
                    if (m == null) {
                        System.out.println("\nError: Mendec not found.");
                    } else {
                        System.out.print("\nEnter plaintext: ");
                        String text = input.nextLine();
                        System.out.println("\nYour ciphertext is '" + m.encrypt(text) + "'\n");
                    }
                    break;
                }
                case 2: {
                    System.out.print("\nEnter mendec ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    Mendec m = findById(mendecs, id);
                    if (m == null) {
                        System.out.println("\nError: Mendec not found.");
                    } else {
                        System.out.print("\nEnter ciphertext: ");
                        String text = input.nextLine();
                        System.out.println("\nYour plaintext is '" + m.decrypt(text) + "'\n");
                    }
                    break;                   
                }
                case 3:{
                    System.out.println("\n1. Caesar Cipher");
                    System.out.println("2. Vigenere Cipher");
                    System.out.println("3. Transposition Cipher");
                    System.out.print("Use which cipher? ");
                    int type = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter mendec name: ");
                    String name = input.nextLine();

                    if (type == 1) {
                        System.out.print("Enter offset: ");
                        int offset = input.nextInt();
                        input.nextLine();
                        mendecs.add(new CaesarCipher(name, offset));
                    } else if (type == 2) {
                        System.out.print("Enter key: ");
                        String key = input.nextLine();
                        mendecs.add(new VigenereCipher(name, key));
                    } else if (type == 3) {
                        System.out.print("Enter width: ");
                        int width = input.nextInt();
                        input.nextLine();
                        mendecs.add(new TransposerCipher(name, width));
                    }
                    System.out.println("Mendec added.\n");
                    break;
                }
                case 4: {
                    System.out.println("\nShow which mendecs? Option are:");
                    System.out.println("ALL");
                    System.out.println("CAE for Caesar Cipher");
                    System.out.println("VIG for Viginere Cipher");
                    System.out.println("TRA for Transposer Cipher");
                    System.out.print("Enter option: ");

                    String choice = input.nextLine().toUpperCase();
                    System.out.println();

                    for (Mendec m : mendecs) {
                        if (choice.equals("ALL")
                            || (choice.equals("CAE") && m instanceof CaesarCipher) 
                            || (choice.equals("VIG") && m instanceof VigenereCipher) 
                            || (choice.equals("TRA") && m instanceof TransposerCipher)) {
                            System.out.println(m);
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.print("\nEnter mendec ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    Mendec m = findById(mendecs, id);

                    if (m == null) {
                        System.out.println("\nError: Mendec not found.");
                    } else {
                        System.out.println();
                        System.out.println(m);
                        System.out.println(m.getDescription());
                        System.out.println();
                    }
                    break;
                }
                case 6: {
                    System.out.print("\nEnter mendec ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    Mendec m = findById(mendecs, id);

                    if (m == null) {
                        System.out.println("\nError: Mendec not found.");
                    } else {
                        mendecs.remove(m);
                        System.out.println("\nMendec removed.");
                    }
                    break;
                }
                case 0:
                    System.out.println("\nShutting off...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (options != 0);

        input.close();
    }
    private static Mendec findById(ArrayList<Mendec> list, int id) {
        for (Mendec m : list) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}
