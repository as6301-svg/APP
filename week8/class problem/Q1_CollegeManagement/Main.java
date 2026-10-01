import student.Student;
import course.Course;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Ayush", "CSE");
        Course course = new Course(501, "Advanced Programming Practice", 4);

        System.out.println("Student Information");
        student.displayInfo();

        System.out.println();

        System.out.println("Course Information");
        course.displayInfo();
    }
}