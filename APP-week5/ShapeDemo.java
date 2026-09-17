abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;
    Circle(double radius) { this.radius = radius; }
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;
    Rectangle(double length, double width) {
        this.length = length; this.width = width;
    }
    @Override
    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base, height;
    Triangle(double base, double height) {
        this.base = base; this.height = height;
    }
    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 7)
        };
        for (Shape s : shapes) {
            System.out.println("Area: " + s.calculateArea());
        }
    }
}