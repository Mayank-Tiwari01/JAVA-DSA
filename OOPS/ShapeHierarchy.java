package OOPS;
abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public abstract void draw();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (Math.PI * radius * radius);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("draw circle with radius " + radius);
    }

}
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with width: " + width + " and height: " + height);
    }
}
class Triangle extends Shape {
    private double a, b, c; // Sides of the triangle

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle with sides: " + a + ", " + b + ", " + c);
    }
    public static class ShapeHierarchy {
        public static void main(String[] args) {

            Shape circle = new Circle(5);
            Shape rectangle = new Rectangle(4, 6);
            Shape triangle = new Triangle(3, 4, 5);

            Shape[] shapes = { circle, rectangle, triangle };

            for (Shape shape : shapes) {
                System.out.println("Area: " + shape.calculateArea());
                System.out.println("Perimeter: " + shape.calculatePerimeter());
                shape.draw();
                System.out.println();
            }
        }
    }
}
