import java.util.ArrayList;

public class QueueOfStudents {
    private ArrayList<Student> students;

    public QueueOfStudents() {
        students = new ArrayList<>();
    }

    public void registerForPickup(Student s) {
        students.add(s);
    }

    public Student deliverBoxOfBooks() {
        if (students.isEmpty()) {
            return null;
        }
        return students.remove(0);
    }
}