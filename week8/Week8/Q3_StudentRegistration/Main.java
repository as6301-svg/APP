import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField(20);

        JLabel regLabel = new JLabel("Register Number:");
        JTextField regField = new JTextField(20);

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel deptLabel = new JLabel("Department:");
        String[] departments = {
            "CSE", "ECE", "EEE", "Mechanical", "Civil"
        };
        JComboBox<String> deptBox = new JComboBox<>(departments);

        JButton submit = new JButton("Submit");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(regLabel);
        frame.add(regField);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);
        frame.add(deptLabel);
        frame.add(deptBox);
        frame.add(submit);

        submit.addActionListener(e -> {
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" : "Not Selected";

            String message =
                "Name: " + nameField.getText() +
                "\nRegister Number: " + regField.getText() +
                "\nGender: " + gender +
                "\nDepartment: " + deptBox.getSelectedItem();

            JOptionPane.showMessageDialog(frame, message);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}