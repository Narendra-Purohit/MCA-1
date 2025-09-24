abstract class Shape {
    protected int dim1;
    protected int dim2;

    Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    Shape(int dim1) {
        this.dim1 = dim1;
    }

    public abstract double area();
    public abstract double perimeter();
}

class Rectangle extends Shape {
    Rectangle(int length, int width) {
        super(length, width);
    }

    public double area() {
        return dim1 * dim2;
    }

    public double perimeter() {
        return 2 * (dim1 + dim2);
    }
}

class Triangle extends Shape {
    private int side1, side2, side3;

    Triangle(int base, int height, int side2, int side3) {
        super(base, height);
        this.side1 = base;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double area() {
        return 0.5 * dim1 * dim2;
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius);
    }

    public double area() {
        return Math.PI * dim1 * dim1;
    }

    public double perimeter() {
        return 2 * Math.PI * dim1;
    }
}

public class Shape10 { 
    public static void main(String[] args) {
        Shape rect = new Rectangle(10, 5);
        System.out.println("Rectangle Area: " + rect.area());
        System.out.println("Rectangle Perimeter: " + rect.perimeter());

        Shape tri = new Triangle(10, 6, 8, 7);
        System.out.println("\nTriangle Area: " + tri.area());
        System.out.println("Triangle Perimeter: " + tri.perimeter());

        Shape circle = new Circle(7);
        System.out.println("\nCircle Area: " + circle.area());
        System.out.println("Circle Circumference: " + circle.perimeter());
    }
}
