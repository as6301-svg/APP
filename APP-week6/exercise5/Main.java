import student.Student;
import course.Course;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", 101, "Computer Science");
        Course c = new Course(10, "Java Programming", 3);

        System.out.println("Student Information:");
        s.displayInfo();

        System.out.println("\nCourse Information:");
        c.displayInfo();
    }
}