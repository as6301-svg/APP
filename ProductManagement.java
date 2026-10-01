import java.sql.*;
import java.util.Scanner;

public class ProductManagement {
    static final String URL = "jdbc:mysql://localhost:3306/store_db";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Insert Product\n2. Retrieve by ProductID\n3. Update Quantity\n4. Display Low Stock (<10)\n5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: insertProduct(con, sc); break;
                    case 2: retrieveProduct(con, sc); break;
                    case 3: updateQuantity(con, sc); break;
                    case 4: lowStock(con); break;
                    case 5: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice");
                }
            } while (choice != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("ProductID: "); int id = sc.nextInt();
        System.out.print("ProductName: "); String name = sc.next();
        System.out.print("Price: "); double price = sc.nextDouble();
        System.out.print("Quantity: "); int qty = sc.nextInt();

        String sql = "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, price);
        ps.setInt(4, qty);
        ps.executeUpdate();
        System.out.println("Product inserted successfully.");
    }

    static void retrieveProduct(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ProductID: "); int id = sc.nextInt();
        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.printf("ID:%d Name:%s Price:%.2f Qty:%d%n",
                    rs.getInt("ProductID"), rs.getString("ProductName"),
                    rs.getDouble("Price"), rs.getInt("Quantity"));
        } else {
            System.out.println("Product not found.");
        }
    }

    static void updateQuantity(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter ProductID: "); int id = sc.nextInt();
        System.out.print("New Quantity: "); int qty = sc.nextInt();

        String sql = "UPDATE Product SET Quantity = ? WHERE ProductID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, qty);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Quantity updated." : "Product not found.");
    }

    static void lowStock(Connection con) throws SQLException {
        String sql = "SELECT * FROM Product WHERE Quantity < 10";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.printf("ID:%d Name:%s Qty:%d%n",
                    rs.getInt("ProductID"), rs.getString("ProductName"), rs.getInt("Quantity"));
        }
    }
}