package CSC3101.lab13;

import java.io.*;
import java.util.Date;

public class Q2 {
    public static void main(String[] args) {
        String filename = "datafile.dat";

        int[] intArray = {9, 8, 7, 1, 2, 3};
        double doubleValue = 11.5;
        Date dateObject = new Date();
        String stringValue = "Hello, world!";

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {

            out.writeInt(intArray.length);
            for (int value : intArray) {
                out.writeInt(value);
            }

            out.writeDouble(doubleValue);

            out.writeLong(dateObject.getTime());

            out.writeUTF(stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {

            int arrayLength = in.readInt();
            int[] readIntArray = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                readIntArray[i] = in.readInt();
            }

            double readDoubleValue = in.readDouble();

            long dateLong = in.readLong();
            Date readDateObject = new Date(dateLong);

            String readStringValue = in.readUTF();

            System.out.print("Read int array: ");
            for (int value : readIntArray) {
                System.out.print(value + " ");
            }
            System.out.println("\nread double value: " + readDoubleValue);
            System.out.println("read Date object: " + readDateObject);
            System.out.println("read string value: " + readStringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

