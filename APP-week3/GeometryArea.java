public class GeometryArea {
    static double calculateArea(double side) {
        return side * side;
    }
    static double calculateArea(double length, double breadth) {
        return length * breadth;
    }
    static double calculateArea(double radius, String shape) {
        if (shape.equalsIgnoreCase("circle")) {
            return Math.PI * radius * radius;
        }
        return 0;
    }
    public static void main(String[] args) {
        double squareArea = calculateArea(5);
        double rectangleArea = calculateArea(4, 6);
        double circleArea = calculateArea(3, "circle");

        System.out.println("Area of Square : " + squareArea);
        System.out.println("Area of Rectangle : " + rectangleArea);
        System.out.println("Area of Circle : " + circleArea);
    }
}