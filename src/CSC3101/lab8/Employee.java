package CSC3101.lab8;

import java.util.Scanner;

//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:8
public class Employee {
    private int idNum;
    private int age;

    public Employee(int idNum, int age) throws EmployeeException {
        if (idNum < 1 || idNum > 999) {
            throw new NumberFormatException("Identification out of range!");
        }
        if (idNum < 0 || age < 0) {
            throw new IllegalArgumentException("Age or ID cannot be negative!");
        }
        this.idNum = idNum;
        this.age = age;
    }

    public int getIdNum() {
        return idNum;
    }

    public int getAge() {
        return age;
    }
}

class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee ID: ");
            String idInput = sc.nextLine();
            int idNum = validateInteger(idInput);

            System.out.print("Enter Employee Age: ");
            String ageInput = sc.nextLine();
            int age = validateInteger(ageInput);

            Employee emp = new Employee(idNum, age);
            System.out.println("Employee created successfully: ID = " + emp.getIdNum() + ", Age = " + emp.getAge());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Done!");
        }

        sc.close();
    }

    private static int validateInteger(String input) throws EmployeeException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new EmployeeException("Value must be an integer! Value: " + input);
        }
    }
}