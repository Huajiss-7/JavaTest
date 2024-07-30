package CSC3101.网工.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileFromURL {
    public static void main(String[] args) {
        System.out.print("enter a file path: ");
        String filePath = new Scanner(System.in).next();

        try {
            File file = new File(filePath);
            int count = 0;
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                count += line.length();
            }
            input.close();
            System.out.println("the file size is " + count + " characters");
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (Exception ex) {
            System.out.println("an error occurred");
            ex.printStackTrace();
        }
    }
}
