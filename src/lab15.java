//liu miao yan
//218479

import java.util.Scanner;

public class lab15 {
   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first String: ");
        String firstString = scanner.nextLine();

        int length = firstString.length();

        if (length > 10) {
            String substring = firstString.substring(4, 10);
            System.out.println("Substring from 5 to 10: " + substring + ", length " + length);
        } else {
            System.out.println("String length less than 10");
        }

        System.out.print("Enter the second String: ");
        String secondString = scanner.nextLine();

        if (firstString.contains(secondString)) {
            System.out.println("Second String exists in First String");
            firstString = firstString.replace(secondString, "Selamat Datang");
            System.out.println("New Statement in String 1: " + firstString);
        } else {
            System.out.println("Second String not exists in First String");
        }

        scanner.close();
    }*/

    //q2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first String: ");
        String firstString = scanner.nextLine();

        int length = firstString.length();

        if (length > 8) {
            System.out.println("Valid password!!");
            System.out.println("First String: \"" + firstString + "\" with length " + length);
        } else {
            System.out.println("Invalid password");
        }

        System.out.print("Enter the second String: ");
        String secondString = scanner.nextLine();

        if (firstString.contains(secondString)) {
            System.out.println("Second String exists in First String");
        } else {
            System.out.println("Second String not exists in First String");
            firstString += secondString;
            System.out.println("New Statement in String 1: " + firstString);
        }

        scanner.close();
    }
}
