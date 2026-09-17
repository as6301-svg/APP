import student.Student;
import course.Course;

public class CollegeManagement {
    public static void main(String[] args) {
        Student student = new Student("RA241100301042", "Rohan Mehta", "Information Technology", 3);
        Course course = new Course("21CSC203P", "Advanced Programming Practice", 4, "Dr. Ashwini S");

        System.out.println("=== College Academic Management System ===");
        System.out.println("\n--- Student Details ---");
        student.displayStudent();

        System.out.println("\n--- Registered Course Details ---");
        course.displayCourse();
    }
}
