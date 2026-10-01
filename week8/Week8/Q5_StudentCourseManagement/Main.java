import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Course Management");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        String[] courses = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Operating Systems",
            "Computer Networks"
        };

        JList<String> courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(courseList);

        String[] columns = {
            "Student Name",
            "Selected Course",
            "Enrollment Status"
        };

        Object[][] data = {};

        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(data, columns);

        JTable table = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(table);

        JTextField studentField = new JTextField(15);

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Student Name:"));
        topPanel.add(studentField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.WEST);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String studentName = studentField.getText();
            String selectedCourse = courseList.getSelectedValue();

            if (studentName.isEmpty() || selectedCourse == null) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Enter student name and select a course."
                );
            } else {
                model.addRow(
                    new Object[]{
                        studentName,
                        selectedCourse,
                        "Enrolled"
                    }
                );

                studentField.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row != -1) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(
                    frame,
                    "Select a registration to remove."
                );
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}