import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ---------- MODEL ----------
class ServiceModel {
    String regNo, vehicleType;
    boolean general, oilChange, brake, battery;
    double totalCost;

    void calculateCost() {
        totalCost = 0;
        if (general) totalCost += 1000;
        if (oilChange) totalCost += 800;
        if (brake) totalCost += 1200;
        if (battery) totalCost += 500;
    }
}

// ---------- VIEW ----------
class ServiceView extends JFrame {
    JTextField regField;
    JComboBox<String> typeBox;
    JCheckBox generalCB, oilCB, brakeCB, batteryCB;
    JButton calcButton;
    JLabel resultLabel;

    ServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setLayout(new GridLayout(8, 1, 5, 5));
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Vehicle Registration Number:"));
        regField = new JTextField();
        add(regField);

        add(new JLabel("Vehicle Type:"));
        typeBox = new JComboBox<>(new String[]{"Two Wheeler", "Car"});
        add(typeBox);

        generalCB = new JCheckBox("General Service - Rs.1000");
        oilCB = new JCheckBox("Oil Change - Rs.800");
        brakeCB = new JCheckBox("Brake Service - Rs.1200");
        batteryCB = new JCheckBox("Battery Check - Rs.500");
        add(generalCB);
        add(oilCB);
        add(brakeCB);
        add(batteryCB);

        calcButton = new JButton("Calculate Cost");
        add(calcButton);

        resultLabel = new JLabel("Total Cost: ");
        add(resultLabel);

        setVisible(true);
    }

    void showResult(String text) {
        resultLabel.setText(text);
    }
}

// ---------- CONTROLLER ----------
class ServiceController {
    ServiceModel model;
    ServiceView view;

    ServiceController(ServiceModel model, ServiceView view) {
        this.model = model;
        this.view = view;

        view.calcButton.addActionListener(e -> calculateCost());
    }

    void calculateCost() {
        model.regNo = view.regField.getText();
        model.vehicleType = (String) view.typeBox.getSelectedItem();
        model.general = view.generalCB.isSelected();
        model.oilChange = view.oilCB.isSelected();
        model.brake = view.brakeCB.isSelected();
        model.battery = view.batteryCB.isSelected();

        model.calculateCost();
        view.showResult(String.format("Reg: %s | Type: %s | Total Cost: Rs.%.1f",
                model.regNo, model.vehicleType, model.totalCost));
    }
}

// ---------- MAIN ----------
public class VehicleServiceEstimator {
    public static void main(String[] args) {
        ServiceModel model = new ServiceModel();
        ServiceView view = new ServiceView();
        new ServiceController(model, view);
    }
}