class Ride {
    int rideNumber;
    String rideName;

    Ride(int rideNumber, String rideName) {
        this.rideNumber = rideNumber;
        this.rideName = rideName;
    }
}

public class RidePattern {
    public static void main(String[] args) {
        Ride[] rides = new Ride[5];
        rides[0] = new Ride(1, "Roller Coaster");
        rides[1] = new Ride(2, "Ferris Wheel");
        rides[2] = new Ride(3, "Bumper Cars");
        rides[3] = new Ride(4, "Water Ride");
        rides[4] = new Ride(5, "Haunted House");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-15s : ", rides[i].rideName);
            for (int j = 0; j < rides[i].rideNumber; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
