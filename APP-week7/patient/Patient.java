package patient;

public class Patient {
    private String patientId;
    private String name;
    private String disease;
    private int age;

    public Patient(String patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getDisease() {
        return disease;
    }

    public int getAge() {
        return age;
    }

    public void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosed Disease: " + disease);
    }
}
