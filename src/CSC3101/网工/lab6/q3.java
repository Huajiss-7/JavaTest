package CSC3101.网工.lab6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) throws IOException {
        String[] products = new String[3];
        Scanner sc = new Scanner(new File("productIn.dat"));
        int i = -1;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            products[++i] = line;
        }
        sc.close();
        Scanner scanner = new Scanner(System.in);
        File file=new File("custOrder.txt");
        if(!file.exists())file.createNewFile();
        FileWriter fw = new FileWriter("custOrder.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        boolean moreClients = true;
        while (moreClients) {
            System.out.print("Client ID: ");
            String clientId = scanner.next();
            System.out.println("A001 quantity order :");
            int numA = scanner.nextInt();
            System.out.println("B002 quantity order :");
            int numB = scanner.nextInt();
            System.out.println("C003 quantity order :");
            int numC = scanner.nextInt();
            System.out.println("Another client?(key in 1 for yes/0 for no) :");
            moreClients = !scanner.next().equalsIgnoreCase("0");

            for (int j = 0; j < products.length; j++) {
                String[] productInfo = products[j].split(":");
                String code = productInfo[0].trim();
                int quantity = Integer.parseInt(productInfo[1].trim());
                double price = Double.parseDouble(productInfo[2].trim());

                int orderQty = 0;
                switch (code) {
                    case "A001":
                        orderQty = numA;
                        break;
                    case "B002":
                        orderQty = numB;
                        break;
                    case "C003":
                        orderQty = numC;
                        break;
                }

                int remainingQty = quantity - orderQty;
                String status;
                if (remainingQty < 200) {
                    status = "MUST REORDER " + (200 - remainingQty);
                } else {
                    status = "OK";
                }

                double totalPrice = orderQty * price;
                pw.printf("%s %s %d %.2f %.2f %d %s%n",
                        clientId, code, orderQty, price,
                        totalPrice, remainingQty, status);

                productInfo[1] = String.valueOf(remainingQty);
                products[j] = String.join(":", productInfo);
            }
        }

        pw.close();
        fw.close();
    }

}