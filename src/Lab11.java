import java.util.Scanner;
import java.util.ArrayList;

public class Lab11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BoxOfBooks> boxes = new ArrayList<>();

        BoxOfBooks programming = new BoxOfBooks("Programming");
        programming.addBook("Databases made Simple");
        programming.addBook("Macros and Scripts");
        programming.addBook("Programming Basics");

        BoxOfBooks chemistry = new BoxOfBooks("Chemistry");
        chemistry.addBook("Organic Chemistry");
        chemistry.addBook("Inorganic Chemistry");
        chemistry.addBook("The Periodic Table of Elements");

        BoxOfBooks math = new BoxOfBooks("Mathematics");
        math.addBook("Linear Algebra");
        math.addBook("Calculus I and II");
        math.addBook("Pre-Calculus");

        boxes.add(programming);
        boxes.add(chemistry);
        boxes.add(math);

        QueueOfStudents queue = new QueueOfStudents();

        System.out.println("[Book Delivery Scheduler]");

        while (true) {
            System.out.println("\n1. Add student");
            System.out.println("2. Create a box of books");
            System.out.println("3. Deliver all boxes");
            System.out.print("Enter option: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("\nEnter name of student: ");
                String name = input.nextLine();

                for (int i = 0; i < boxes.size(); i++) {
                    System.out.println(i + ": " + boxes.get(i).getBoxName());
                }

                System.out.print("Give them which box? ");
                int index = input.nextInt();
                input.nextLine();

                Student s = new Student(name, boxes.get(index).copy());
                queue.registerForPickup(s);

                System.out.println("Student added to queue.");
            }
            else if (choice == 2) {
                System.out.print("\nEnter box name: ");
                String name = input.nextLine();

                BoxOfBooks newBox = new BoxOfBooks(name);

                while (true) {
                    System.out.print("Enter name of book or '-done': ");
                    String book = input.nextLine();

                    if (book.equals("-done"))
                        break;
                    
                    System.out.println("Book added to box.");
                    newBox.addBook(book);
                }

                boxes.add(newBox);
                System.out.println("Box of Books registered for future use.");
            }
            else if (choice == 3) {
                System.out.println("\nHere are all the students and the contents of their boxes:");
                while (true) {
                    Student s = queue.deliverBoxOfBooks();
                    if (s == null)
                        break;

                    System.out.println(s);
                }
                System.out.println("\nShutting off...");
                break;
            }
        }
        input.close();
    }
    
}
