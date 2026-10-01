import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ---------- MODEL ----------
class StudentModel {
    String name;
    double m1, m2, m3, total, average;
    String grade;

    void calculate() {
        total = m1 + m2 + m3;
        average = total / 3;
        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";
    }
}

// ---------- VIEW ----------
class StudentView extends JFrame {
    JTextField nameField, m1Field, m2Field, m3Field;
    JButton calcButton;
    JLabel resultLabel;

    StudentView() {
        setTitle("Student Grade Calculator");
        setLayout(new GridLayout(6, 2, 5, 5));
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Marks Subject 1:"));
        m1Field = new JTextField();
        add(m1Field);

        add(new JLabel("Marks Subject 2:"));
        m2Field = new JTextField();
        add(m2Field);

        add(new JLabel("Marks Subject 3:"));
        m3Field = new JTextField();
        add(m3Field);

        calcButton = new JButton("Calculate Result");
        add(calcButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        setVisible(true);
    }

    void showResult(String text) {
        resultLabel.setText(text);
    }
}

// ---------- CONTROLLER ----------
class StudentController {
    StudentModel model;
    StudentView view;

    StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;

        view.calcButton.addActionListener(e -> calculateResult());
    }

    void calculateResult() {
        try {
            model.name = view.nameField.getText();
            model.m1 = Double.parseDouble(view.m1Field.getText());
            model.m2 = Double.parseDouble(view.m2Field.getText());
            model.m3 = Double.parseDouble(view.m3Field.getText());
            model.calculate();
            view.showResult(String.format("%s | Total: %.1f | Avg: %.2f | Grade: %s",
                    model.name, model.total, model.average, model.grade));
        } catch (NumberFormatException ex) {
            view.showResult("Enter valid numeric marks!");
        }
    }
}

// ---------- MAIN ----------
public class StudentGradeCalculator {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();
        new StudentController(model, view);
    }
}