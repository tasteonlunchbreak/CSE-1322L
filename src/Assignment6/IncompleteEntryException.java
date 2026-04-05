package Assignment6;
public class IncompleteEntryException extends Exception {
    private int lineNumber;
    private String info;

    public IncompleteEntryException (String message, int lineNumber, String info) {
        super(message);
        this.lineNumber = lineNumber;
        this.info = info;
    }
    public int getLineNumber() {
        return lineNumber;
    }
    public String getInfo() {
        return info;
    }
}
