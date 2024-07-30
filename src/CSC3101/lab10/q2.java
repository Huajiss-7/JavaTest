package CSC3101.lab10;

import java.io.*;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1-record\n2-search friend information\n3-leave");
            int flag=sc.nextInt();
            switch (flag){
                case 1->record();
                case 2->search();
                case 3-> {
                    sc.close();
                    return;
                }
            }
        }
    }

    public static void record(){
        Scanner scanner = new Scanner(System.in);
        String filePath = "friends.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            System.out.print("Enter friend's name ");
            String name = scanner.nextLine();

            System.out.print("Enter friend's phone number: ");
            String phoneNumber = scanner.nextLine();

            if (name.isEmpty() || phoneNumber.isEmpty()) {
                throw new IllegalArgumentException("Name and phone number cannot be empty");
            }

            writer.println(name + " " + phoneNumber);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
        scanner.close();
    }


    public static void search(){
        Scanner scanner = new Scanner(System.in);
        String filePath = "friends.txt";

        System.out.print("Enter the name to search: ");
        String searchName = scanner.nextLine().toLowerCase();

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.toLowerCase().contains(searchName)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No records found for the name: " + searchName);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        scanner.close();
    }
}
