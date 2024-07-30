package CSC3101.lab11;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the width or height length of the square: ");
        Square square = new Square(sc.nextDouble());

        System.out.print("enter the width and height length of the triangle: ");
        Triangle triangle = new Triangle(sc.nextDouble(), sc.nextDouble());

        System.out.println("\nsquare information:");
        System.out.println(square);
        square.printSides();
        System.out.println(square.printObjectType());

        System.out.println("\ntriangle information:");
        System.out.println(triangle);
        triangle.printSides();
        System.out.println(triangle.printObjectType());

        System.out.println("\ncomparison result:");
        if (square.equals(triangle)) {
            System.out.println("the square and triangle are equal.");
        } else {
            System.out.println("the square and triangle are not equal.");
        }

        sc.close();
    }
}

abstract class GeometricFigure {
    private String objectName;

    public GeometricFigure(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }

    public abstract double findArea();

    @Override
    public String toString() {
        return "object Name: " + objectName + ", area: " + findArea();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof GeometricFigure)) return false;
        GeometricFigure that = (GeometricFigure) obj;
        return objectName.equals(that.objectName) && Double.compare(that.findArea(), findArea()) == 0;
    }
}

interface SidedObject {
    void printSides();
}

interface ObjectType {
    String printObjectType();
}

class Square extends GeometricFigure implements SidedObject, ObjectType {
    private double height;
    private double width;

    public Square(double heightAndweigth) {
        super("square");
        this.height = heightAndweigth;
        this.width = heightAndweigth;
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        this.width = side;
        this.height=side;
    }

    @Override
    public double findArea() {
        return height * width;
    }

    @Override
    public void printSides() {
        System.out.println("square has 4 sides.");
    }

    @Override
    public String printObjectType() {
        return "this is a square.";
    }
}

class Triangle extends GeometricFigure implements SidedObject, ObjectType {
    private double width;
    private double height;

    public Triangle(double width, double height) {
        super("triangle");
        this.width=width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double findArea() {
        return 0.5 * width * height;
    }

    @Override
    public void printSides() {
        System.out.println("triangle has 3 sides.");
    }

    @Override
    public String printObjectType() {
        return "this is a triangle.";
    }
}