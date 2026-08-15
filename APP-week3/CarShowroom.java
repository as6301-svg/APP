public class CarShowroom {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Swift");
        Car car3 = new Car("Creta", 1200000.0);
        Car car4 = new Car("Nexon", 950000.0);

        Car[] cars = { car1, car2, car3, car4 };
        for (Car c : cars) {
            c.displayDetails();
        }
        System.out.println("Total Cars Registered : " + Car.totalCars);
        Car mostExpensive = cars[0];
        for (Car c : cars) {
            if (c.price > mostExpensive.price) {
                mostExpensive = c;
            }
        }
        System.out.println("Most Expensive Car : " + mostExpensive.model + " (₹" + mostExpensive.price + ")");
    }
}
class Car {
    int carId;
    String model;
    double price;
    static int totalCars = 0;
    static int idCounter = 100;
    Car() {
        this.carId = ++idCounter;
        this.model = "Not Specified";
        this.price = 0.0;
        totalCars++;
    }
    Car(String model) {
        this.carId = ++idCounter;
        this.model = model;
        this.price = 0.0;
        totalCars++;
    }
    Car(String model, double price) {
        this.carId = ++idCounter;
        this.model = model;
        this.price = price;
        totalCars++;
    }
    void displayDetails() {
        System.out.println("Car ID : " + carId);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
        System.out.println("--------------------");
    }
}