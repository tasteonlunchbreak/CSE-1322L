package Lab11;
import java.util.ArrayList;

public class BoxOfBooks {
    private String boxName;
    private ArrayList<String> books;

    public BoxOfBooks (String name) {
    this.boxName = name;
    this.books = new ArrayList<>();
    
}

    public String getBoxName() {
        return boxName;
    }

    public void addBook(String book) {
        books.add(0, book);
    }

    public String retrieveBook() {
        if (books.isEmpty()) {
            return null;
        }
        return books.remove(0);
    }

    public BoxOfBooks copy() {
        BoxOfBooks newBox = new BoxOfBooks(this.boxName);

        for (String book : this.books) {
            newBox.books.add(book);
        }
        return newBox;
    }
}
