//liu miao yan
//218479

import java.util.Scanner;

public class lab14 {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter park type (1-ThemePark, 2-WaterPark, 3-Both Park): ");
        int parkType = scanner.nextInt();

        double ticketCharge = calculateTicketCharge(age, parkType);

        System.out.println("Ticket Charge: RM" + ticketCharge);
    }

    public static double calculateTicketCharge(int age, int parkType) {
        double ticketCharge = 0;

        if (age > 55) {
            ticketCharge = (parkType == 1) ? 10 : (parkType == 2) ? 15 : 20;
        } else if (age >= 21 && age <= 54) {
            ticketCharge = (parkType == 1) ? 25 : (parkType == 2) ? 30 : 45;
        } else if (age >= 13 && age <= 20) {
            ticketCharge = (parkType == 1) ? 20 : (parkType == 2) ? 25 : 40;
        } else if (age >= 3 && age <= 12) {
            ticketCharge = (parkType == 1) ? 10 : (parkType == 2) ? 15 : 20;
        } else {
            System.out.println("Invalid age");
        }

        return ticketCharge;
    }*/

    //q2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter BMI: ");
        double bmi = scanner.nextDouble();

        System.out.print("Enter waist size (in inches): ");
        double waistSize = scanner.nextDouble();

        calculateAndDisplayHealthRisk(gender, bmi, waistSize);
    }

    private static void calculateAndDisplayHealthRisk(char gender, double bmi, double waistSize) {
        System.out.println("BMI Category: " + determineBMICategory(bmi));

        if ((gender == 'F' && waistSize > 35) || (gender == 'M' && waistSize > 40)) {
            System.out.println("CAUTION!! HIGHER RISK FOR HEART DISEASE AND TYPE 2 DIABETES!!");
        }
    }

    private static String determineBMICategory(double bmi) {
        if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Over Weight";
        } else if (bmi >= 30 && bmi <= 34.9) {
            return "Obese";
        } else if (bmi >= 35) {
            return "Severely Obese";
        } else {
            return "Invalid BMI";
        }
    }

    //q3
/*public static void main(String[]args) {
Scanner input=new Scanner(System.in);
System.out.println("ALL CODE:MCS ME MPM MEOH");
System.out.println("Code Program");
String code=input.nextLine();
System.out.println("Semester No:");
int sem=input.nextInt();
System.out.println("Credit Hours Registered:");
int credit=input.nextInt();
System.out.println("---------------------------------------------------- ----------");
switch(code) {
case "MCS":{
if(sem<1||credit<0) {
System.out.println("error");
return;
}
int fee=0;
if(sem==1) {
fee=1250+credit*250;
}
else {
fee=1000+credit*250;
}
System.out.println("Master Program: Master of Computer Science");
System.out.println("Semester No: "+sem);
System.out.println("Credit Hours:"+credit);
System.out.println("Total Tuition Fees: RM"+fee);
break;
}
case "ME":{
if(sem<1||credit<0) {
System.out.println("error");
return;
}
int fee=0;
if(sem==1) {
fee=1400+credit*250;
}
else {
fee=1100+credit*250;
}
System.out.println("Master Program: Master of Environment");
System.out.println("Semester No: "+sem);
System.out.println("Credit Hours:"+credit);
System.out.println("Total Tuition Fees: RM"+fee);
break;
}
case "MPM":{
if(sem<1||credit<0) {
System.out.println("error");
return;
}
int fee=0;
if(sem==1) {
fee=1250+credit*275;
}
else {
fee=1000+credit*275;
}
System.out.println("Master Program: Master in Plantation Management");
System.out.println("Semester No: "+sem);
System.out.println("Credit Hours:"+credit);
System.out.println("Total Tuition Fees: RM"+fee);
break;
}
case "MEOH":{
if(sem<1||credit<0) {
System.out.println("error");
return;
}
int fee=0;
if(sem==1) {
fee=1250+credit*350;
}
else {
fee=1000+credit*350;
}
System.out.println("Master Program: Master of Environmental and Occupational Health");
System.out.println("Semester No: "+sem);
System.out.println("Credit Hours:"+credit);
System.out.println("Total Tuition Fees: RM"+fee);
break;
}
default:{
System.out.println("invalid code");
break;
}
 }
}*/
}
