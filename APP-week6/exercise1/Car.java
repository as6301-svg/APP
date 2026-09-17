public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String vehicleNumber, String brand, double speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Doors: " + numberOfDoors);
    }
}