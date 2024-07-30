package CSC3101.lab12;

import java.io.*;
//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:12
public class Q1 {
    public static void main(String[] args) {
        //q*17.6
        StudentExamScore[] students = {
                new StudentExamScore(1, "zhang san", 10),
                new StudentExamScore(2, "li si", 20),
                new StudentExamScore(3, "wang wu", 30),
                new StudentExamScore(4, "zhao liu", 40),
                new StudentExamScore(5, "sun qi", 50)
        };

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_06.dat"))) {
            for (StudentExamScore student : students) {
                output.writeObject(student);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //q*17.7
        double totalScore = 0;
        double highestScore = 0;
        String highestScoreStudentName = "";
        int highestScoreStudentID = 0;
        int count = 0;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_06.dat"))) {
            while (true) {
                try {
                    StudentExamScore student = (StudentExamScore) input.readObject();
                    totalScore += student.getExamScore();
                    count++;

                    if (student.getExamScore() > highestScore) {
                        highestScore = student.getExamScore();
                        highestScoreStudentName = student.getStudentName();
                        highestScoreStudentID = student.getStudentID();
                    }
                } catch (EOFException ex) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        double averageScore = totalScore / count;
        System.out.println("Average examination score: " + averageScore);
        System.out.println("Highest examination score: " + highestScore);
        System.out.println("Student with the highest score: " + highestScoreStudentName + " (ID: " + highestScoreStudentID + ")");
    }
}


class StudentExamScore implements Serializable {
    private int studentID;
    private String studentName;
    private double examScore;

    public StudentExamScore(int studentID, String studentName, double examScore) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.examScore = examScore;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getExamScore() {
        return examScore;
    }
}