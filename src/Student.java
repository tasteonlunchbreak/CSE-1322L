public class Student {
    private String studentName;
    private BoxOfBooks boxOfBooks;


    public Student(String name, BoxOfBooks box) {
        this.studentName = name;
        this.boxOfBooks = box;
    }

    public String unpackBoxOfBooks() {
        String result = "";

        String book;
        while((book = boxOfBooks.retrieveBook()) != null) {
            result += book + "\n";
        }
        return result;
    }

    @Override
    public String toString() {
        return "Student: " + studentName + "\nBooks:\n" + unpackBoxOfBooks();
    }
}
