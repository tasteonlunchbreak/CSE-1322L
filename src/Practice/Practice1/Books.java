package Practice.Practice1;
public class Books {
    //fields
    private String title;
    private String author;
    private int numbPages;

    //constructor
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | Pages: " + numbPages +"\n";
    }
    //methods
    public Books(String title, String author, int numbPages) {
        this.title = title;
        this.author = author;
        this.numbPages = numbPages;
    }

    public boolean isLongBook() {
        if (numbPages <= 300) {
            return false;
        }
        return true;
    }
}
