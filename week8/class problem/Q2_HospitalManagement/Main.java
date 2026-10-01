import doctor.Doctor;
import patient.Patient;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(101, "Dr. Sharma", "Cardiology", 800);
        Doctor doctor2 = new Doctor(102, "Dr. Mehta", "Neurology", 1000);

        Patient patient1 = new Patient(201, "Rahul", "Heart Disease", 45);
        Patient patient2 = new Patient(202, "Priya", "Migraine", 28);
        Patient patient3 = new Patient(203, "Aman", "Heart Disease", 52);

        Patient[] patients = {patient1, patient2, patient3};
        Doctor[] assignedDoctors = new Doctor[patients.length];

        for (int i = 0; i < patients.length; i++) {
            if (patients[i].getDisease().equalsIgnoreCase("Heart Disease")) {
                assignedDoctors[i] = doctor1;
            } else {
                assignedDoctors[i] = doctor2;
            }
        }

        int doctor1Patients = 0;
        int doctor2Patients = 0;

        for (int i = 0; i < patients.length; i++) {
            System.out.println("Patient Details");
            patients[i].displayInfo();

            System.out.println("Treating Doctor");
            assignedDoctors[i].displayInfo();

            System.out.println();

            if (assignedDoctors[i] == doctor1) {
                doctor1Patients++;
            } else {
                doctor2Patients++;
            }
        }

        System.out.println("Total Consultation Fee Collected");
        System.out.println(doctor1.getName() + ": " +
                (doctor1Patients * doctor1.getConsultationFee()));

        System.out.println(doctor2.getName() + ": " +
                (doctor2Patients * doctor2.getConsultationFee()));
    }
}