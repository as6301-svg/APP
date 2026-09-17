import doctor.Doctor;
import patient.Patient;

public class HospitalManagement {
    public static void main(String[] args) {
        Doctor doc1 = new Doctor("DOC101", "Dr. Rajesh Sharma", "Cardiology", 800.0);
        Doctor doc2 = new Doctor("DOC102", "Dr. Priya Nair", "Dermatology", 600.0);

        Doctor[] doctors = { doc1, doc2 };

        Patient p1 = new Patient("PAT01", "Ananya Rao", "Heart Arrhythmia", 45);
        Patient p2 = new Patient("PAT02", "Karan Kapoor", "Skin Allergy", 28);
        Patient p3 = new Patient("PAT03", "Suresh Kumar", "Hypertension", 62);

        Patient[] patients = { p1, p2, p3 };

        Doctor[] assignedDoctor = new Doctor[patients.length];
        int[] patientCountPerDoctor = new int[doctors.length];

        for (int i = 0; i < patients.length; i++) {
            String disease = patients[i].getDisease().toLowerCase();
            if (disease.contains("heart") || disease.contains("hypertension")) {
                assignedDoctor[i] = doc1;
                patientCountPerDoctor[0]++;
            } else {
                assignedDoctor[i] = doc2;
                patientCountPerDoctor[1]++;
            }
        }

        System.out.println("=== Hospital Management System ===");
        System.out.println("\n--- Patient Consultations & Assigned Doctors ---");
        for (int i = 0; i < patients.length; i++) {
            System.out.println("----------------------------------------");
            patients[i].displayPatient();
            System.out.println("Assigned Doctor: " + assignedDoctor[i].getName() + " (" + assignedDoctor[i].getSpecialization() + ")");
            System.out.println("Consultation Fee: ₹" + assignedDoctor[i].getConsultationFee());
        }

        System.out.println("\n--- Total Consultation Fees Collected ---");
        for (int i = 0; i < doctors.length; i++) {
            double totalFees = patientCountPerDoctor[i] * doctors[i].getConsultationFee();
            System.out.println(doctors[i].getName() + " [" + doctors[i].getSpecialization() + "]:");
            System.out.println("Total Patients Assigned: " + patientCountPerDoctor[i]);
            System.out.println("Total Revenue Collected: ₹" + totalFees);
            System.out.println();
        }
    }
}
