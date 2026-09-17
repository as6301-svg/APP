package student;

public class Student {
    private String name;
    private int id;
    private String major;

    public Student(String name, int id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Major: " + major);
    }
}