import java.util.Scanner;

public class lab6 {
    //q3
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String flag="Y";
        while (flag.equals("Y")){

            //menu
            System.out.println("BMI information:\n" +
                    "BMI (18.5-24.9) -> Normal\n" +
                    "BMI (25-29.9) -> Over Weight\n" +
                    "BMI (30-34.9) -> Obese\n" +
                    "BMI (35-39.9) -> Severely Obese\n" +
                    "BMI (>=40) -> Morbidly Obese\n");
            System.out.println("********************************************\n" +
                    "CAUTION!!\n" +
                    "Women – waist size > 35 inches\n" +
                    "Men – waist size > 40 inches  \n" +
                    "----- HIGHER RISK FOR HEART DISEASE AND TYPE 2 DIABETES!!------\n" +
                    "\n" +
                    "*******************************************\n" +
                    "\n" +
                    "HEALTH CALCULATOR\n");

            //data
            System.out.println("Enter your name:");
            String name=sc.nextLine();
            System.out.println("Enter your height in meters : ");
            double height= sc.nextDouble();
            System.out.println("Enter your weight in kilogram :");
            double weight= sc.nextDouble();
            System.out.println("Enter your waist size in inches :");
            double waistSize= sc.nextDouble();

            //calculate BMI
            double bmi=weight/(height*height);

            //show
            if(bmi>=18.5&&bmi<=24.9) System.out.println(name+",your BMI is "+bmi+", so that means you are Normal and has a good life style..Congratss!!!!.");
            if(bmi>=25&&bmi<=29.9) System.out.println(name+",your BMI is "+bmi+", so that means you are over weight");
            if(bmi>=30&&bmi<=34.9) System.out.println(name+",your BMI is "+bmi+", so that means you are obese");
            if(bmi>=35&&bmi<=39.9) System.out.println(name+",your BMI is "+bmi+", so that means you are Obese and has higher risk for heart disease and diabetes!!!");
            if(bmi>=40) System.out.println(name+",your BMI is "+bmi+", so that means you are too fat");

            //continue
            System.out.println("Continue with next person? Y/other");
            flag=sc.next();
        }//while
    }*/

    //q4
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<20;i++){
            double claim=0;
            System.out.println("Hello, employee number "+(i+1));
            System.out.println("Please enter your travel distance(km)");
            double distance= sc.nextDouble();
            if(distance<=500&&distance>=0)claim=distance*0.7;
            else if(distance>500)claim=350+(distance-500)*0.5;
            else {
                System.out.println("invalid data please re-enter");
                i--;
            }
            System.out.println("your total mileage claim is"+claim);
            System.out.println();
        }
    }
}
