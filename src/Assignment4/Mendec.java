package Assignment4;
public abstract class Mendec {
    //variables
    private String name;
    private String description;
    private int id;
    private static int nextId = 0;

    //constructors
    public Mendec(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextId;
        nextId++;
    }

    //methods
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getId() {
        return id;
    }

    public abstract String encrypt(String text);
    public abstract String decrypt(String text);

}
