package Practice.Practice1;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Books> books = new ArrayList<>();

        int options;

        System.out.println("[Library Catalog]");

        do {
            System.out.println("1. Add book");
            System.out.println("2. Display all books");
            System.out.println("3. Display long books");
            System.out.println("4. Remove a book");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");
            options = input.nextInt();
            input.nextLine();

            switch (options) {
                case 1:
                    System.out.print("What is the title of the book? ");
                    String bookTitle = input.nextLine();
                    System.out.print("Who is the author of the book? ");
                    String bookAuthor = input.nextLine();
                    System.out.print("How many pages does this book have? ");
                    int bookPages = input.nextInt();
                    input.nextLine();

                    books.add(new Books(bookTitle, bookAuthor, bookPages));
                    System.out.println("Book added.\n");
                    break;
                case 2:
                    System.out.println(books.toString());
                    break;
                case 3:

                case 4:
                case 5:
                default:

            } 
        } while (options != 5);
        input.close();
    }
}
