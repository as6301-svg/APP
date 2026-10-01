public class Bike extends Vehicle {
    private boolean hasGear;

    public Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Gear: " + hasGear);
    }
}