//Author's name:ZHANG ZHE
//Matric number:218629
//Lab No:14

import java.util.Scanner;

public class lab16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students");
        int numStudents = scanner.nextInt();

        String[] matricNo = new String[numStudents];
        int[] quizMarks = new int[numStudents];
        int[] assignmentMarks = new int[numStudents];
        int[] midtermMarks = new int[numStudents];
        int[] finalExamMarks = new int[numStudents];
        int[] totalMarks = new int[numStudents];
        String[] grades = new String[numStudents];

        // Read the marks
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter matric number for student " + (i + 1) + ": ");
            matricNo[i] = scanner.next();
            System.out.print("Enter 3 quiz marks for student " + (i + 1) + ": ");
            quizMarks[i] = calculateQuiz();
            System.out.print("Enter 2 assignment marks for student " + (i + 1) + ": ");
            assignmentMarks[i] = calculateAssignment();
            System.out.print("Enter midterm marks for student " + (i + 1) + ": ");
            midtermMarks[i] = readMark();
            System.out.print("Enter final exam marks for student " + (i + 1) + ": ");
            finalExamMarks[i] = readMark();
        }

        // Calculate the total marks and determine the grade
        for (int i = 0; i < numStudents; i++) {
            totalMarks[i] = calculateTotalMarks(quizMarks[i], assignmentMarks[i], midtermMarks[i], finalExamMarks[i]);
            grades[i] = determineGrade(totalMarks[i]);
        }

        // Display the data in a table
        showTable(matricNo, quizMarks, assignmentMarks, midtermMarks, finalExamMarks, totalMarks, grades, numStudents);

        // Calculate the number of students for each grade with its percentage
        calculateGradeDistribution(grades);

        scanner.close();
    }

    //read the mark
    public static int readMark() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //calculate the quizzes
    public static int calculateQuiz() {
        return readMark() + readMark() + readMark();
    }

    //calculate the quizzes
    public static int calculateAssignment() {
        return readMark() + readMark();
    }

    // Calculate the total marks
    public static int calculateTotalMarks(int quiz, int assignment, int midterm, int finalExam) {
        return (int) (quiz / 3 + assignment / 2 + midterm / 2.5 + finalExam / 2);
    }

    // Determine the grade based on total marks
    public static String determineGrade(int totalMarks) {
        if (totalMarks >= 80) {
            return "A";
        } else if (totalMarks >= 70) {
            return "B";
        } else if (totalMarks >= 55) {
            return "C";
        } else if (totalMarks >= 45) {
            return "D";
        } else {
            return "F";
        }
    }


    //show table
    public static void showTable(String[] matricNo, int[] quizMarks, int[] assignmentMarks, int[] midtermMarks, int[] finalExamMarks, int[] totalMarks, String[] grades, int numStudents) {
        System.out.println("\nMatric No\tQuiz\tAssign\tMidterm\tFinal Exam\tTotal Marks\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(matricNo[i] + "\t\t" + quizMarks[i] / 3 + "\t" + assignmentMarks[i] / 2 + "\t" + midtermMarks[i] / 2.5 + "\t" + finalExamMarks[i] / 2 + "\t\t" + totalMarks[i] + "\t\t" + grades[i]);
        }
    }

    // Calculate the number of students for each grade with its percentage
    public static void calculateGradeDistribution(String[] grades) {
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int i = 0; i < grades.length; i++) {
            String grade = grades[i];
            switch (grade) {
                case "A":
                    countA++;
                    break;
                case "B":
                    countB++;
                    break;
                case "C":
                    countC++;
                    break;
                case "D":
                    countD++;
                    break;
                case "F":
                    countF++;
                    break;
            }
        }

        int totalStudents = grades.length;
        System.out.println("\nGrade A - " + countA + " students (" + (countA * 100.0 / totalStudents) + "%)");
        System.out.println("Grade B - " + countB + " students (" + (countB * 100.0 / totalStudents) + "%)");
        System.out.println("Grade C - " + countC + " students (" + (countC * 100.0 / totalStudents) + "%)");
        System.out.println("Grade D - " + countD + " students (" + (countD * 100.0 / totalStudents) + "%)");
        System.out.println("Grade F - " + countF + " students (" + (countF * 100.0 / totalStudents) + "%)");
    }

}