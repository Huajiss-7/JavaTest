package CSC3101.网工.lab9;

import CSC3101.网工.lab9.q1a.Circle;
import CSC3101.网工.lab9.q1a.Rectangle;
import CSC3101.网工.lab9.q1a.Triangle;

import java.util.ArrayList;
import java.util.Random;

import static CSC3101.网工.lab9.q1b.TestClass.min;

public  class q1c {
    public static void main(String[] args) {
        // Create ArrayLists
        ArrayList<Rectangle> rectangleList = new ArrayList<>();
        ArrayList<Circle> circleList = new ArrayList<>();
        ArrayList<Triangle> triangleList = new ArrayList<>();

        // Populate with 15 Rectangle, Circle, and Triangle objects
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            double length = random.nextDouble() * 8 + 2; // Random double between 2 and 10
            double width = random.nextDouble() * 8 + 2;
            Rectangle rectangle = new Rectangle(length, width);
            rectangleList.add(rectangle);

            double radius = random.nextDouble() * 8 + 2;
            Circle circle = new Circle(radius);
            circleList.add(circle);

            double side1 = random.nextDouble() * 8 + 2;
            double side2 = random.nextDouble() * 8 + 2;
            double side3 = random.nextDouble() * 8 + 2;
            Triangle triangle = new Triangle(side1, side2, side3);
            triangleList.add(triangle);
        }
        for (int i=0;i<10;i++){
            Circle circle = circleList.get(i);
            System.out.println("Circle " + (i + 1) + " -> Radius: " + circle.getRadius()+ ", Perimeter: " + circle.getPerimeter());
        }

        // Find and print minimum perimeter for each type
        Rectangle minRectangle = min(rectangleList);
        Circle minCircle = min(circleList);
        Triangle minTriangle = min(triangleList);

        System.out.println("Minimum perimeter of Rectangles: " + minRectangle.getPerimeter());
        System.out.println("Minimum perimeter of Circles: " + minCircle.getPerimeter());
        System.out.println("Minimum perimeter of Triangles: " + minTriangle.getPerimeter());
    }
}
