import java.util.Scanner;
import java.util.ArrayList;

public class Lab3 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("[Phonebook]");

    ArrayList<String[]> phonebook = new ArrayList<>();
    boolean running = true;

    while (running) { 
        System.out.println("1. Add contact");
        System.out.println("2. Remove contact");
        System.out.println("3. List contacts");
        System.out.println("4. Search contacts");
        System.out.println("5. Quit");
        System.out.print("Enter option: ");

        int options = input.nextInt();
        input.nextLine();

        switch(options) {
            case 1:
                System.out.print("Enter the contact's name: ");
                String name = input.nextLine();
                System.out.print("Enter the contact's phone number: ");
                String phone = input.nextLine();

                String[] contact = new String[2];
                contact[0] = name;
                contact[1] = phone;

                phonebook.add(contact);
                System.out.println("Contact added.\n");
                break;
            case 2:
                System.out.print("Enter contact to remove: ");
                String remove = input.nextLine();

                boolean isRemoved = false;

                for (int i = 0; i < phonebook.size(); i++) {
                    if (phonebook.get(i)[0].equals(remove)) {
                    phonebook.remove(i);
                    System.out.println("Contact deleted.\n");  
                    isRemoved = true;
                    break;
                    }
                }
                if (!isRemoved) {
                    System.out.println("No contact with that name.\n");
                }
                break;
            case 3:
                if (phonebook.size() == 0) {
                    System.out.println("The phonebook is empty.\n");
                } else {
                    System.out.println("Listing all contacts...");
                    for (String[] c : phonebook) {
                        System.out.println("Name: " +c[0]+" | Phone: " +c[1]);
                    }
                    System.out.println("Done listing contacts.\n");
                }
                break;
            case 4:
                System.out.print("Enter keyword to search: ");
                String keyword = input.nextLine();

                boolean keywordFound = false;
                System.out.println("Searching all contacts for keyword...");

                for (String[] c : phonebook){
                    if (c[0].contains(keyword)) {
                        System.out.println("Name: " +c[0]+" | Phone: " +c[1]);
                        keywordFound = true;
                    }
                }
                if (!keywordFound) {
                    System.out.println("No contacts contained the keyword.\n");
                } else {
                    System.out.println("Done searching keyword.\n");
                }
                break;
            case 5:
                System.out.println("Shutting off...");
                running = false;
                break;  
            default:
                System.out.println("\nInvalid option. Try again.");
                break;
            }
        }
    input.close();
    } 
}