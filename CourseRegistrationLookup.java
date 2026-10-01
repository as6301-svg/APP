import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationLookup {
    static final String URL = "jdbc:mysql://localhost:3306/college_db";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Course Code: ");
            String courseCode = sc.next();

            String sql = "SELECT * FROM CourseRegistration WHERE CourseCode = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, courseCode);
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("StudentID:%d Name:%s Course:%s Semester:%d%n",
                        rs.getInt("StudentID"), rs.getString("StudentName"),
                        rs.getString("CourseName"), rs.getInt("Semester"));
            }

            if (!found) {
                System.out.println("No students registered for course code: " + courseCode);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}