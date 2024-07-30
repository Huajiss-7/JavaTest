package CSC3101.lab10;
//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:10
import java.io.*;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("1-regist\n2-search regist information\n3-leave");
            int flag=sc.nextInt();
            switch (flag){
                case 1->regist();
                case 2->search();
                case 3-> {
                    sc.close();
                    return;
                }
            }
        }
    }

    public static void regist(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your account number");
        String acc = sc.nextLine();
        System.out.println("enter your name");
        String name = sc.nextLine();
        System.out.println("enter your lawn size");
        String size = sc.nextLine();
        int sizeN;
        try {
            sizeN = Integer.parseInt(size);
        }catch (NumberFormatException e){
            System.out.println("your size is not a number");
            return;
        }
        String fee="";
        if(sizeN<1000){
            fee="50.00";
        }
        else if (sizeN>=1000) {
            fee="75.00";
        }
        File service=new File("LawnService.txt");
        if(!service.exists()){
            try {
                service.createNewFile();
            } catch (IOException e) {
                System.out.println("can not creat the file");
                System.exit(0);
            }
        }
        try (Scanner fsc=new Scanner(service)){
            int lineCount=0;
            while (fsc.hasNextLine()) {
                fsc.nextLine();
                lineCount++;
            }
            if(lineCount>10){
                System.out.println("Registration is full");
                return;
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }
        try (PrintWriter pw=new PrintWriter(new FileWriter(service,true))){
            pw.write(acc+" "+name+" "+size+" "+fee+"\n");
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("file not found");
            System.exit(0);
        }
    }

    public static void search(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the account number you want to query");
        String acc = sc.nextLine();
        File service=new File("LawnService.txt");
        try (Scanner input=new Scanner(service)){
            while (input.hasNextLine()){
                String info = input.nextLine();
                String[] accInFile = info.split(" ");
                if(accInFile[0].equals(acc)){
                    System.out.println("the regist information(account number,name,size,fee) is "+info);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }
    }
}
