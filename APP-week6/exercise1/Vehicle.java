public class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected double speed;

    public Vehicle(String vehicleNumber, String brand, double speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}