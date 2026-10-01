package course;

public class Course {
    private int courseId;
    private String title;
    private int credits;

    public Course(int courseId, String title, int credits) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
    }

    public void displayInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Credits: " + credits);
    }
}