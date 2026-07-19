public class ShapeAreaPerimeterHierarchyImmutability {

    public static abstract class Shape {
        public abstract double area();
        public abstract double perimeter();
    }

    public static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public double area() {
            return Math.PI * radius * radius;
        }

        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public static class Rectangle extends Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double area() {
            return length * width;
        }

        public double perimeter() {
            return 2 * (length + width);
        }
    }

    public static class Triangle extends Shape {
        private double a;
        private double b;
        private double c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }

        public double getC() {
            return c;
        }

        public void setC(double c) {
            this.c = c;
        }

        public double perimeter() {
            return a + b + c;
        }

        public double area() {
            double s = perimeter() / 2.0;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(7.5);
        shapes[1] = new Rectangle(10.0, 5.0);
        shapes[2] = new Triangle(3.0, 4.0, 5.0);

        System.out.println("Area Report");
        for (int i = 0; i < shapes.length; i++) {
            Shape s = shapes[i];
            String type;
            if (s instanceof Circle) type = "Circle";
            else if (s instanceof Rectangle) type = "Rectangle";
            else type = "Triangle";

            System.out.print(type);
            System.out.print(" area=");
            System.out.print(String.format(java.util.Locale.US, "%.2f", s.area()));
            System.out.print(" perimeter=");
            System.out.print(String.format(java.util.Locale.US, "%.2f", s.perimeter()));
            if (i < shapes.length - 1) System.out.println();
        }
    }
}

