import java.util.Scanner;

public class lab17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student number:");
        int studentNum = scanner.nextInt();
        int[] number = new int[studentNum];
        int[][] mark = new int[studentNum][7];
        int[] total = new int[studentNum];
        String[] grade = new String[studentNum];
        for (int i = 0; i < studentNum; i++) {
            System.out.println("Enter student matric number for student" + (i + 1));
            number[i] = scanner.nextInt();
            System.out.println("Enter 3 quiz marks for student" + (i + 1));
            mark[i][1] = scanner.nextInt();
            mark[i][2] = scanner.nextInt();
            mark[i][0] = scanner.nextInt();
            System.out.println("Enter 2 assignment marks for student" + (i + 1));
            mark[i][3] = scanner.nextInt();
            mark[i][4] = scanner.nextInt();
            System.out.println("Enter midterm marks for student" + (i + 1));
            mark[i][5] = scanner.nextInt();
            System.out.println("Enter final exam marks for student" + (i + 1));
            mark[i][6] = scanner.nextInt();
            for (int j = 0; j < mark[i].length; j++) {
                total[i] += mark[i][j];
            }
            grade[i] = grade(total[i]);


        }


    }

    public static String grade(int mark) {

        if (mark > 50) return "A";
        else if (mark <= 50 && mark > 30) return "B";
        return "C";
    }


}
