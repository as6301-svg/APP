import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("User Login");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JCheckBox rememberMe = new JCheckBox("Remember Me");
        JCheckBox notifications = new JCheckBox("Receive Notifications");

        JButton loginButton = new JButton("Login");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(rememberMe);
        frame.add(notifications);
        frame.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Please enter username and password."
                );
            } else {
                JOptionPane.showMessageDialog(
                    frame,
                    "Login Successful!\nUsername: " + username +
                    "\nRemember Me: " + rememberMe.isSelected() +
                    "\nReceive Notifications: " + notifications.isSelected()
                );
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}