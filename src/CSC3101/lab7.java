package CSC3101;

import java.util.InputMismatchException;
import java.util.Scanner;

//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:7
public class lab7 {
    public static void main(String[] args) {
        //q1
        //exception handler
        //version1();
        //without exception
        //version2();

        //q2
        //q2();

        //q3
        q3();
    }

    private static void version1() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter first number: ");
            String num1 = sc.nextLine();

            System.out.print("Enter second number: ");
            String num2 = sc.nextLine();

            System.out.println("select operator\n1-a+b\n2-a-b\n3-exit");

            int operator ;
            try {
                operator = sc.nextInt();
            } catch (InputMismatchException e) {
                throw e;
            }
            sc.nextLine();
            double a,b;

            switch (operator) {
                case 1:
                    try {
                        a = Double.parseDouble(num1);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input :"+num1);
                        return;
                    }
                    try {
                        b = Double.parseDouble(num2);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input :"+num2);
                        return;
                    }
                    System.out.println(a+"+"+b+"="+(a+b));
                    break;
                case 2:
                    try {
                        a = Double.parseDouble(num1);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input :"+num1);
                        return;
                    }
                    try {
                        b = Double.parseDouble(num2);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input :"+num2);
                        return;
                    }
                    System.out.println(a+"-"+b+"="+(a-b));
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }


    public static void version2(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter first number: ");
            String num1 = sc.nextLine();

            System.out.print("Enter second number: ");
            String num2 = sc.nextLine();

            System.out.println("select operator\n1-a+b\n2-a-b\n3-exit");

            String operator = sc.nextLine();

            double a,b;
            boolean flag1=true;
            boolean flag2=true;

            switch (operator) {
                case "1":
                    for (int i = 0; i < num1.length(); i++) {
                        if(!Character.isDigit(num1.charAt(i)))flag1=false;
                    }
                    for (int i = 0; i < num2.length(); i++) {
                        if(!Character.isDigit(num2.charAt(i)))flag2=false;
                    }
                    if(flag1){
                        a = Double.parseDouble(num1);
                    }else {
                        System.out.println("Wrong input :"+num1);
                        return;
                    }
                    if(flag2){
                        b = Double.parseDouble(num2);
                    }else {
                        System.out.println("Wrong input :"+num2);
                        return;
                    }

                    System.out.println(a+"+"+b+"="+(a+b));
                    break;
                case "2":
                    for (int i = 0; i < num1.length(); i++) {
                        if(!Character.isDigit(num1.charAt(i)))flag1=false;
                    }
                    for (int i = 0; i < num2.length(); i++) {
                        if(!Character.isDigit(num2.charAt(i)))flag2=false;
                    }
                    if(flag1){
                        a = Double.parseDouble(num1);
                    }else {
                        System.out.println("Wrong input :"+num1);
                        return;
                    }
                    if(flag2){
                        b = Double.parseDouble(num2);
                    }else {
                        System.out.println("Wrong input :"+num2);
                        return;
                    }

                    System.out.println(a+"-"+b+"="+(a-b));
                    break;
                case "3":
                    System.exit(0);
            }

        }
    }


    public static void q2() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 12: ");
        int monthNumber = sc.nextInt();

        try {
            String month = months[monthNumber - 1];
            int days = dom[monthNumber - 1];
            System.out.println(month + " has " + days + " days.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong number: please enter a number between 1 and 12.");
            throw e;
        }
    }

    public static void q3(){
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter an integer: ");
                number = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next();//因为sc.nextInt()无法接受不是整数的值，导致错误值一直在输入缓存中，如果不写这个把错值吃了，会尝试把值给sc.nextInt()但出错无限循环，
            }
        }

        System.out.println("You entered: " + number);
    }
}
