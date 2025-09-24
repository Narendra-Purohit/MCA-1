interface Shape {
    double area();
    double perimeter();
}

class Rectangle implements Shape {
    private double l, w;

    public Rectangle(double l, double w) 
    {
        this.l = l;
        this.w = w;
    }

    public double area() 
    {
        return l * w;
    }

    public double perimeter() 
    {
        return 2 * (l + w);
    }
}

class Triangle implements Shape {
    private double base, height, side2, side3;

    public Triangle(double base, double height, double side2, double side3) 
    {
        this.base = base;
        this.height = height;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double area() 
    {
        return 0.5 * base * height;
    }

    public double perimeter() 
    {
        return base + side2 + side3;
    }
}

class circle implements Shape{
    private double r;
    public circle(double r) 
    {
        this.r=r;    
    }

    public double area() 
    {
        return Math.PI * r * r;
    }

    public double perimeter() 
    {
        return 2 * Math.PI * r;
    }
}

public class interface11 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(1, 2);
        System.out.println("Rectangle area : " + r.area());
        System.out.println("Rectangle perimeter : " + r.perimeter());

        Triangle t = new Triangle(3, 4, 5, 6);
        System.out.println("\nTriangle area : " + t.area());
        System.out.println("Triangle perimeter : " + t.perimeter());

        circle c=new circle(7);
        System.out.println("\nCircle Area: " + c.area());
        System.out.println("Circle Circumference: " + c.perimeter());
    }
}
