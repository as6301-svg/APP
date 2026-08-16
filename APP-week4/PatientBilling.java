import java.util.Scanner;

class Patient {
    String name;
    double consultationFee;

    Patient(String name, double consultationFee) {
        this.name = name;
        this.consultationFee = consultationFee;
    }

    double calculateFinalAmount(double fee) {
        double discount = (fee >= 2000) ? fee * 0.10 : fee * 0.05;
        return fee - discount;
    }

    void display(double fee, double discount) {
        System.out.println("Patient Name: " + name);
        System.out.println("Original Consultation Fee: Rs" + fee);
        System.out.println("Discount: Rs" + discount);
        System.out.println("Final Amount: Rs" + (fee - discount));
        System.out.println();
    }
}

public class PatientBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patient[] patients = new Patient[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Patient " + (i + 1) + " Name: ");
            String name = sc.next();
            System.out.print("Enter Consultation Fee: ");
            double fee = sc.nextDouble();
            patients[i] = new Patient(name, fee);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            Patient p = patients[i];
            double fee = p.consultationFee;
            double discount = (fee >= 2000) ? fee * 0.10 : fee * 0.05;
            p.display(fee, discount);
        }
    }
}
