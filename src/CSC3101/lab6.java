package CSC3101;

import java.util.ArrayList;
import java.util.Scanner;

//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:6
public class lab6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the radius of a circle: ");
        double radius = scanner.nextDouble();
        shapes.add(new Circle1(radius));

        System.out.print("Enter the base and height of a triangle: ");
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        shapes.add(new Triangle1(base, height));

        System.out.print("Enter the side of a square: ");
        double sideSquare = scanner.nextDouble();
        shapes.add(new Square(sideSquare));

        System.out.print("Enter the side of a cube: ");
        double sideCube = scanner.nextDouble();
        shapes.add(new Cube(sideCube));

        System.out.print("Enter the radius of a sphere: ");
        double radiusSphere = scanner.nextDouble();
        shapes.add(new Sphere(radiusSphere));

        for (int i=0;i<shapes.size();i++) {
            System.out.println("Area: " + shapes.get(i).calArea());
        }

        scanner.close();
    }

}


abstract class Shape {
    public abstract double calArea();
}

abstract class TwoDimensionalShape extends Shape {
}

abstract class ThreeDimensionalShape extends Shape {
    public abstract double calVolume();
}

class Circle1 extends TwoDimensionalShape {
    private double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }

    @Override
    public double calArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle1 extends TwoDimensionalShape {
    private double base;
    private double height;

    public Triangle1(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calArea() {
        return 0.5 * base * height;
    }
}

class Square extends TwoDimensionalShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calArea() {
        return side * side;
    }
}

class Cube extends ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calArea() {
        return 6 * side * side;
    }

    @Override
    public double calVolume() {
        return side * side * side;
    }
}

class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}

