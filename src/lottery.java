import java.util.Scanner;
import java.util.Random;

public class lottery {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] user = new int[5];
        System.out.println("please enter your lottery number");
        for (int i = 0; i < user.length; i++) {
            user[i] = in.nextInt();
        }
        Random random = new Random();
        int[] lotteryNumbers = new int[5];

        for (int i = 0; i < lotteryNumbers.length; i++) {
            lotteryNumbers[i] = random.nextInt(9) + 1;
        }
        int cnt = 0;
        for (int i = 0; i < lotteryNumbers.length; i++) {
            if (lotteryNumbers[i] == user[i])
                cnt++;
        }

        System.out.println("Lottery numbers:");
        for (int number : lotteryNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("Numbers of matching digits:" + cnt);
    }

}
