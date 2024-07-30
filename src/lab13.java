//liu miao yan
//218479

import java.util.Scanner;

public class lab13 {
//q2
  /*  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalA = 0;
        int totalB = 0;
        int totalC = 0;
        int totalD = 0;
        double totalWeight = 0;

        char continueChoice='y';

        while (continueChoice == 'y' || continueChoice == 'Y') {
            System.out.print("Enter egg weight (gram): ");
            double weight = scanner.nextDouble();

            char grade = getGrade(weight);
            System.out.println("Grade for this egg: " + grade);

            if ((totalA + totalB + totalC + totalD) % 10 == 0) {
                System.out.println("\n*** Report for every 10 eggs produced ***");
                countGrade(totalWeight, 'A');
                countGrade(totalWeight, 'B');
                countGrade(totalWeight, 'C');
                countGrade(totalWeight, 'D');
                displayReport(totalWeight, totalA, totalB, totalC, totalD);
                System.out.println("*****************************************\n");
            }

            switch (grade) {
                case 'A':
                    totalA++;
                    break;
                case 'B':
                    totalB++;
                    break;
                case 'C':
                    totalC++;
                    break;
                case 'D':
                    totalD++;
                    break;
            }

            totalWeight += weight;

            System.out.print("Do you want to continue? (y/n): ");
            continueChoice = scanner.next().charAt(0);

        }
    }
    public static char getGrade(double weight) {
        if (weight > 44) {
            return 'A';
        } else if (weight >= 30 && weight <= 44) {
            return 'B';
        } else if (weight >= 25 && weight < 30) {
            return 'C';
        } else {
            return 'D';
        }
    }

    public static void countGrade(double totalWeight, char grade) {
        System.out.println("Total " + grade + " grade eggs: " + (int) totalWeight);
    }

    public static void displayReport(double totalWeight, int totalA, int totalB, int totalC, int totalD) {
        System.out.println("Average weight for A grade: " + (totalA > 0 ? totalWeight / totalA : 0));
        System.out.println("Average weight for B grade: " + (totalB > 0 ? totalWeight / totalB : 0));
        System.out.println("Average weight for C grade: " + (totalC > 0 ? totalWeight / totalC : 0));
        System.out.println("Average weight for D grade: N/A (rejected)");

        System.out.println("Total weight of all eggs produced: " + totalWeight);
    }*/

    //q3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char continueChoice='y';

        while (continueChoice == 'y' || continueChoice == 'Y') {
            System.out.print("Enter student's name: ");
            String studentName = scanner.nextLine();

            // Read and calculate quizzes average
            double quizzesAverage = calculateAverage("Quiz", 3, 15);

            // Read and calculate assignment average
            double assignmentAverage = calculateAverage("Assignment", 2, 25);

            // Read marks for Mid-Term and Final Exams
            int midTermExamMark = readMark("Mid-Term Exam");
            int finalExamMark = readMark("Final Exam");

            // Calculate total mark
            double totalMark = calculateTotalMark(quizzesAverage, assignmentAverage, midTermExamMark, finalExamMark);

            // Determine grade based on total mark
            char grade = determineGrade(totalMark);

            // Display final mark and grade
            displayResult(studentName, totalMark, grade);

            System.out.print("More grade computation? (y/n): ");
            continueChoice = scanner.next().charAt(0);

            // Consume the newline character
            scanner.nextLine();

        }
    }

    public static double calculateAverage(String category, int numberOfItems, double fullMark) {
        Scanner scanner = new Scanner(System.in);
        double totalMarks = 0;

        for (int i = 1; i <= numberOfItems; i++) {
            System.out.print("Enter mark for " + category + i + ": ");
            totalMarks += scanner.nextInt();
        }

        double average = totalMarks / numberOfItems;
        System.out.println(category + "s average is: " + average);
        return average;
    }

    public static int readMark(String examType) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + examType + " mark: ");
        return scanner.nextInt();
    }

    public static double calculateTotalMark(double quizzesAverage, double assignmentAverage, int midTermExamMark, int finalExamMark) {
        double quizzesWeight = 0.15;
        double assignmentWeight = 0.25;
        double midTermWeight = 0.20;
        double finalExamWeight = 0.40;

        return quizzesAverage * quizzesWeight + assignmentAverage * assignmentWeight
                + midTermExamMark * midTermWeight + finalExamMark * finalExamWeight;
    }

    public static char determineGrade(double totalMark) {
        if (totalMark >= 80) {
            return 'A';
        } else if (totalMark >= 70) {
            return 'B';
        } else if (totalMark >= 55) {
            return 'C';
        } else if (totalMark >= 45) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void displayResult(String studentName, double totalMark, char grade) {
        System.out.printf("%s, your final mark for CSC3100 is %.2f and grade %c.%n%n", studentName, totalMark, grade);
    }
}
