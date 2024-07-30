package CSC3101.网工.lab9;

public class q1a {

    // Interface for Comparable Part(a)
    interface ComparableShape {
        double getPerimeter();
    }

    // Rectangle class implementing Comparable
    static class Rectangle implements Comparable<Rectangle>, ComparableShape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getPerimeter() {
            return 2 * (length + width);
        }
        public int compareTo(Rectangle other) {
            return Double.compare(this.getPerimeter(), other.getPerimeter());
        }
    }

    // Circle class implementing Comparable
    static class Circle implements Comparable<Circle>, ComparableShape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
        public int compareTo(Circle other) {
            return Double.compare(this.getPerimeter(), other.getPerimeter());
        }
    }

    // Triangle class implementing Comparable
    static class Triangle implements Comparable<Triangle>, ComparableShape {
        private double side1;
        private double side2;
        private double side3;

        public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        public int compareTo(Triangle other) {
            return Double.compare(this.getPerimeter(), other.getPerimeter());
        }
    }
}
