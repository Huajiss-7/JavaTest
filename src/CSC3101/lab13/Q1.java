package CSC3101.lab13;

import java.io.*;
import java.util.Random;
//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:13
public class Q1 {
    public static void main(String[] args) {
        String filename = "integers.dat";
        Random random = new Random();

        int numberOfIntegers = 70 + random.nextInt(81);
        int[] integers = new int[numberOfIntegers];
        int sum = 0;

        for (int i = 0; i < numberOfIntegers; i++) {
            integers[i] = random.nextInt();
            sum += integers[i];
        }

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            for (int i : integers) {
                out.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of integers :" + sum);

        int readSum = 0;
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            while (true) {
                readSum += in.readInt();
            }
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of integers read from the file: " + readSum);

    }
}
