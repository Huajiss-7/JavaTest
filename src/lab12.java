import java.util.Scanner;

//liu miao yan
//218479
public class lab12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continueChoice='y';

        while (continueChoice == 'y' || continueChoice == 'Y') {
            int age = getAge();
            double weight = getWeight();
            double height = getHeight();
            String gender = getGender();
            int choice = getChoice();

            if (choice == 1) {
                double BMI = calculateBMI(weight, height);
                displayBMIOutput(BMI, height, weight);
            } else if (choice == 2) {
                double BMR = calculateBMR(age, gender, weight, height);
                displayBMROutput(BMR, age, gender);
            } else {
                System.out.println("wrong code");
            }

            System.out.print("Do you want to continue? (y/n): ");
            continueChoice = scanner.next().charAt(0);

        }
    }

    public static int getAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        return scanner.nextInt();
    }

    public static double getWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight (kg): ");
        return scanner.nextDouble();
    }

    public static double getHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter height (cm): ");
        return scanner.nextDouble();
    }

    public static int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter choice (1-BMI, 2-BMR): ");
        return scanner.nextInt();
    }

    public static String getGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Gender (f/m): ");
        return scanner.next();
    }

    public static double calculateBMI(double weight, double height) {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    public static double calculateBMR(int age, String gender, double weight, double height) {
        if (gender.equalsIgnoreCase("m")) {
            return 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
        } else if (gender.equalsIgnoreCase("f")) {
            return 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
        } else {
            return 0.0; // Invalid gender
        }
    }

    public static void displayBMIOutput(double BMI, double height, double weight) {
        System.out.printf("Your height is %.2f cm and weight is %.2f kg. So your BMI is %.2f\n", height, weight, BMI);
    }

    public static void displayBMROutput(double BMR, int age, String gender) {
        System.out.printf("Your age is %d. So your BMR is %.2f\n", age, BMR);
    }


}
