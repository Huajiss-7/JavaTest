package CSC3101.网工.lab5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//q1
class Rectangle {
    private double width;
    private double length;
    private static int noofObj = 0;

    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
        noofObj++;
    }

    public Rectangle(double width, double length) {
        setWidth(width);
        setLength(length);
        noofObj++;
    }

    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("width must be positive.");
        this.width = width;
    }

    public void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("length must be positive.");
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public static int getNoofObj() {
        return noofObj;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    public double getArea() {
        return width * length;
    }

    public void displayAreaPerimeter() {
        System.out.println("area: " + getArea() + ", perimeter: " + getPerimeter());
    }
}

class RectangleTest {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        double totalArea = 0;
        double totalPerimeter = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {
                System.out.print("enter width and length for rectangle " + (i + 1) + ": ");
                double width = scanner.nextDouble();
                double length = scanner.nextDouble();
                Rectangle rect = new Rectangle(width, length);
                rectangles.add(rect);
                totalArea += rect.getArea();
                totalPerimeter += rect.getPerimeter();
            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        } catch (Exception e) {
            System.out.println("exception");
        } finally {
            for (Rectangle rect : rectangles) {
                rect.displayAreaPerimeter();
            }

            double averageArea = totalArea / rectangles.size();
            double averagePerimeter = totalPerimeter / rectangles.size();
            System.out.println("average Area: " + averageArea + ", average Perimeter: " + averagePerimeter);

            System.out.println("total Number of rectangles created: " + Rectangle.getNoofObj());
            System.out.println("DONE EXCEPTION");
        }
    }
}


//q2
class Q2Test {
    public static void main(String[] args) {
        ArrayList<Staff> staffList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("enter staff type (1 for academic, 2 for non academic): ");
                int type = scanner.nextInt();
                System.out.print("enter staff id: ");
                int id = scanner.nextInt();
                System.out.print("enter staff name: ");
                String name = scanner.next();
                System.out.print("enter staff email: ");
                String email = scanner.next();
                System.out.print("enter staff grade: ");
                String grade = scanner.next();

                if (type == 1) {
                    System.out.print("enter title: ");
                    String title = scanner.next();
                    staffList.add(new Academic(id, name, email, grade, title));
                } else if (type == 2) {
                    System.out.print("enter position: ");
                    String position = scanner.next();
                    staffList.add(new NonAcademic(id, name, email, grade, position));
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException " );
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException ");
        } catch (StaffException e) {
            System.err.println("StaffException" );
        } finally {
            for (Staff staff : staffList) {
                displayDetailsInformation(staff);
            }
            System.out.println("DONE EXCEPTION");
        }
    }

    public static void displayDetailsInformation(Object obj) {
        if (obj instanceof Staff) {
            System.out.println(((Staff) obj));
        }
        if (obj instanceof Academic) {
            System.out.println(((Academic) obj));
        }
        if (obj instanceof NonAcademic) {
            System.out.println(((NonAcademic) obj));
        }
    }
}

public class StaffException extends Exception {
    public StaffException(int id) {
        super("staff id " + id + " cannot be negative.");
    }
}

class Staff {
    private int id;
    private String name;
    private String email;
    private String grade;

    public Staff(int id, String name, String email, String grade) throws StaffException, NumberFormatException {
        setId(id);
        setName(name);
        setEmail(email);
        setGrade(grade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws StaffException, NumberFormatException {
        if (id < 0) {
            throw new StaffException(id);
        } else if (id > 9999) {
            throw new NumberFormatException("Staff ID " + id + " out of range");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        if (!grade.matches("DS\\d{2}")) {// regex to validate
            throw new InputMismatchException("grade must be a String value (example DS52/DS58)");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "staff id: " + id + ", name: " + name + ", email: " + email + ", grade: " + grade;
    }
}

class Academic extends Staff {
    private String title;

    public Academic(int id, String name, String email, String grade, String title) throws StaffException, NumberFormatException {
        super(id, name, email, grade);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + ", title: " + title;
    }
}

class NonAcademic extends Staff {
    private String position;

    public NonAcademic(int id, String name, String email, String grade, String position) throws StaffException, NumberFormatException {
        super(id, name, email, grade);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() + ", position: " + position;
    }
}

