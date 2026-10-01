import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ---------- MODEL ----------
class EmployeeModel {
    String validUser = "admin";
    String validPass = "admin123";

    boolean validateLogin(String user, String pass) {
        return validUser.equals(user) && validPass.equals(pass);
    }

    boolean validatePasswordChange(String oldPass, String newPass, String confirmPass) {
        return validPass.equals(oldPass) && newPass.equals(confirmPass);
    }
}

// ---------- LOGIN VIEW ----------
class LoginView extends JFrame {
    JTextField userField;
    JPasswordField passField;
    JButton loginButton;

    LoginView() {
        setTitle("Login");
        setLayout(new GridLayout(3, 2, 5, 5));
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        loginButton = new JButton("Login");
        add(loginButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// ---------- MAIN APP VIEW ----------
class MainAppView extends JFrame {
    JMenuBar menuBar;
    JMenu employeeMenu, toolsMenu;
    JMenuItem addEmployeeItem, viewEmployeeItem, changePasswordItem, exitItem, logoutItem, exitAppItem;

    MainAppView() {
        setTitle("Employee Management Portal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        employeeMenu = new JMenu("Employee");
        addEmployeeItem = new JMenuItem("Add Employee");
        viewEmployeeItem = new JMenuItem("View Employee");
        employeeMenu.add(addEmployeeItem);
        employeeMenu.add(viewEmployeeItem);

        toolsMenu = new JMenu("Tools");
        changePasswordItem = new JMenuItem("Change Password");
        exitItem = new JMenuItem("Exit");
        logoutItem = new JMenuItem("Logout");
        exitAppItem = new JMenuItem("Exit Application");
        toolsMenu.add(changePasswordItem);
        toolsMenu.add(logoutItem);
        toolsMenu.add(exitAppItem);

        menuBar.add(employeeMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void showAddEmployeeForm() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        Object[] fields = {
            "Employee ID:", idField,
            "Employee Name:", nameField,
            "Department:", deptField
        };
        int option = JOptionPane.showConfirmDialog(this, fields, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, "Employee Added: " + nameField.getText());
        }
    }

    void showChangePasswordForm(EmployeeModel model) {
        JPasswordField oldPass = new JPasswordField();
        JPasswordField newPass = new JPasswordField();
        JPasswordField confirmPass = new JPasswordField();
        Object[] fields = {
            "Old Password:", oldPass,
            "New Password:", newPass,
            "Confirm Password:", confirmPass
        };
        int option = JOptionPane.showConfirmDialog(this, fields, "Change Password", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            boolean valid = model.validatePasswordChange(
                    new String(oldPass.getPassword()),
                    new String(newPass.getPassword()),
                    new String(confirmPass.getPassword()));
            if (valid) {
                model.validPass = new String(newPass.getPassword());
                JOptionPane.showMessageDialog(this, "Password changed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Old password incorrect or passwords don't match!");
            }
        }
    }
}

// ---------- CONTROLLER ----------
class EmployeeController {
    EmployeeModel model;
    LoginView loginView;
    MainAppView mainView;

    EmployeeController(EmployeeModel model, LoginView loginView) {
        this.model = model;
        this.loginView = loginView;

        loginView.loginButton.addActionListener(e -> handleLogin());
    }

    void handleLogin() {
        String user = loginView.userField.getText();
        String pass = new String(loginView.passField.getPassword());

        if (model.validateLogin(user, pass)) {
            JOptionPane.showMessageDialog(loginView, "Login Successful!");
            loginView.dispose();
            openMainApp();
        } else {
            JOptionPane.showMessageDialog(loginView, "Invalid Username or Password!");
        }
    }

    void openMainApp() {
        mainView = new MainAppView();

        mainView.addEmployeeItem.addActionListener(e -> mainView.showAddEmployeeForm());
        mainView.viewEmployeeItem.addActionListener(e ->
                JOptionPane.showMessageDialog(mainView, "Viewing employee list..."));
        mainView.changePasswordItem.addActionListener(e -> mainView.showChangePasswordForm(model));
        mainView.logoutItem.addActionListener(e -> {
            mainView.dispose();
            LoginView newLogin = new LoginView();
            new EmployeeController(model, newLogin);
        });
        mainView.exitAppItem.addActionListener(e -> System.exit(0));
        mainView.exitItem.addActionListener(e -> System.exit(0));
    }
}

// ---------- MAIN ----------
public class EmployeeManagementPortal {
    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel();
        LoginView loginView = new LoginView();
        new EmployeeController(model, loginView);
    }
}