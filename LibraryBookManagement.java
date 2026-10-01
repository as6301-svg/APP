import java.sql.*;
import java.util.Scanner;

public class LibraryBookManagement {
    static final String URL = "jdbc:mysql://localhost:3306/library_db";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Insert Book\n2. Search by BookID\n3. Display Available Books\n4. Change Availability\n5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: insertBook(con, sc); break;
                    case 2: searchBook(con, sc); break;
                    case 3: displayAvailable(con); break;
                    case 4: changeAvailability(con, sc); break;
                    case 5: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice");
                }
            } while (choice != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("BookID: "); int id = sc.nextInt();
        System.out.print("Title: "); String title = sc.next();
        System.out.print("Author: "); String author = sc.next();
        System.out.print("Price: "); double price = sc.nextDouble();
        System.out.print("Availability (Y/N): "); String avail = sc.next();

        String sql = "INSERT INTO Book (BookID, Title, Author, Price, Availability) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, title);
        ps.setString(3, author);
        ps.setDouble(4, price);
        ps.setString(5, avail);
        ps.executeUpdate();
        System.out.println("Book inserted successfully.");
    }

    static void searchBook(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter BookID: "); int id = sc.nextInt();
        String sql = "SELECT * FROM Book WHERE BookID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.printf("ID:%d Title:%s Author:%s Price:%.2f Availability:%s%n",
                    rs.getInt("BookID"), rs.getString("Title"), rs.getString("Author"),
                    rs.getDouble("Price"), rs.getString("Availability"));
        } else {
            System.out.println("Book not found.");
        }
    }

    static void displayAvailable(Connection con) throws SQLException {
        String sql = "SELECT * FROM Book WHERE Availability = 'Y'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.printf("ID:%d Title:%s Author:%s Price:%.2f%n",
                    rs.getInt("BookID"), rs.getString("Title"), rs.getString("Author"), rs.getDouble("Price"));
        }
    }

    static void changeAvailability(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter BookID to update: "); int id = sc.nextInt();
        System.out.print("New Availability (Y/N): "); String avail = sc.next();

        String sql = "UPDATE Book SET Availability = ? WHERE BookID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, avail);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Availability updated." : "Book not found.");
    }
}