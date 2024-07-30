package CSC3101.lab12;

import java.io.*;

public class Q2 {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             DataOutputStream output = new DataOutputStream(new FileOutputStream("output.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.writeUTF(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        File inputFile = new File("input.txt");
        File outputFile = new File("output.dat");

        System.out.println("Text file size: " + inputFile.length() + " bytes");
        System.out.println("Binary file size: " +outputFile.length() + " bytes");
    }
}
