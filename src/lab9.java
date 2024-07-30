//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:9

import java.io.*;
import java.util.Scanner;

public class lab9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Enter name: (or enter \"q\" to exit)");
            String name = scanner.nextLine();
            if(name.equals("q"))break;
            System.out.print("Enter position: ");
            String position = scanner.nextLine();
            System.out.print("Enter hours worked: ");
            int hoursWorked = scanner.nextInt();
            System.out.print("Enter rate per hour: ");
            double ratePerHour = scanner.nextDouble();
            scanner.nextLine();
            // Calculate salary
            double salary = hoursWorked * ratePerHour;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Employees.txt", true))) {
                // Use String.format to format the output with specified width for each field
                String formattedData = String.format("%-10s %-15s %-5d %-5.2f %-7.2f", name, position, hoursWorked, ratePerHour, salary);
                writer.write(formattedData);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // Print
        try (BufferedReader reader = new BufferedReader(new FileReader("Employees.txt"))) {
            String line;
            int lineNumber = 1;
            System.out.println("No\tName\tPosition\tHour\tRate\tSalary");
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + " " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }


    //q1
   /* public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String fileName = "Employees.txt";
        PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
        while (true) {
            System.out.print("Enter name (or \"q\" to exit): ");
            String name = input.nextLine();
            if (name.equals("q")) {
                break;
            }
            System.out.print("Enter position: ");
            String position = input.nextLine();
            System.out.print("Enter hours: ");
            int hours = input.nextInt();
            input.nextLine();
            System.out.print("Enter rate: ");
            double rate = input.nextDouble();
            input.nextLine();

            writer.println( ". " + name + ", " + position + ", " + hours + " hours, $" + rate + " per hour");
        }
        writer.close();
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(", ");
            String name = parts[0].substring(3);
            String position = parts[1];
            int hours = Integer.parseInt(parts[2].split(" ")[0]);
            double rate = Double.parseDouble(parts[3].split(" ")[0]);
            double salary = hours * rate;
            System.out.println(  name + ", " + position + ", " + hours + " hours, $" + rate + " per hour, Daily Salary: $" + salary);
        }
        fileScanner.close();

    }*/


    //q2
/*public static void main(String[]args) {
	System.out.println("enter five number");
	double a=read_input();
	double b=read_input();
	double c=read_input();
	double d=read_input();
	double e=read_input();
	double average=calc_average(a,b,c,d,e);
	print_output(average);
}//main

public static double read_input() {
	Scanner sc=new Scanner(System.in);
	return sc.nextDouble();
}

public static double calc_average(double a,double b,double c,double d,double e) {
	return (a+b+c+d+e)/5;
}

public static void print_output(double aver) {
	System.out.println("average is"+aver);
}*/

}
