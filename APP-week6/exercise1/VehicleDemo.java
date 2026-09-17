public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("C001", "Toyota", 120, 4);
        Bike bike = new Bike("B001", "Yamaha", 90, true);

        Vehicle[] vehicles = {car, bike};

        for (Vehicle v : vehicles) {
            v.displayDetails();
            System.out.println();
        }
    }
}