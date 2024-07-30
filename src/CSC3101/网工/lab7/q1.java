package CSC3101.网工.lab7;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class q1 {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 30; i++) {
            if (rand.nextBoolean()) {
                double radius = 1 + (99 * rand.nextDouble());
                shapes.add(new Circle("color" + i, radius));
            } else {
                double width = 1 + (99 * rand.nextDouble());
                double height = 1 + (99 * rand.nextDouble());
                shapes.add(new Triangle("color" + i, width, height));
            }
        }


        double maxArea = Double.MIN_VALUE;
        double minArea = Double.MAX_VALUE;
        Shape maxShape = null;
        Shape minShape = null;

        for (Shape shape : shapes) {
            System.out.println("shape: " + shape.getClass().getSimpleName());
            System.out.println("color: " + shape.getColor());
            System.out.println("area: " + shape.getArea() + " units");
            System.out.println("perimeter: " + shape.getPerimeter() + " units");
            System.out.println("----------------------------");

            if (shape.getArea() > maxArea) {
                maxArea = shape.getArea();
                maxShape = shape;
            }
            if (shape.getArea() < minArea) {
                minArea = shape.getArea();
                minShape = shape;
            }
        }

        System.out.println("shape with the largest area: " + maxShape.getClass().getSimpleName() + " with area " + maxArea + " units");
        System.out.println("shape with the smallest area: " + minShape.getClass().getSimpleName() + " with area " + minArea + " units");
    }
}


abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public boolean checkRadius() {
        return radius > 0;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends Shape {
    private double width;
    private double height;

    public Triangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public boolean checkWidthHeight() {
        return width > 0 && height > 0;
    }

    @Override
    public double getArea() {
        return 0.5 * width * height;
    }

    @Override
    public double getPerimeter() {
        // Assuming it's an equilateral triangle for simplicity
        return 3 * width;
    }
}

interface Resizable {
    double resize(double percent) throws NoSuchFieldException, IllegalAccessException;
}

class ResizableCircle extends Circle implements Resizable {

    public ResizableCircle(String color, double radius) {
        super(color, radius);
    }

    //in uml radius is private no getter and setter how resize? reflect? no teach in class
    @Override
    public double resize(double percent) throws NoSuchFieldException, IllegalAccessException {
        //use gpt
        Class<Circle> clazz = Circle.class;
        Field radius = clazz.getDeclaredField("radius");
        radius.setAccessible(true);
        double aDouble = radius.getDouble(this);
        double newRadius = aDouble * (1 + percent / 100);
        radius.setDouble(this, newRadius);
        return newRadius;
    }

}

interface PrintObject {
    void printArea();
    void printPerimeter();
}