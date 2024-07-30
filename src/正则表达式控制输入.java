import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class 正则表达式控制输入 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        do {
            System.out.println("请输入一个整数：");
            String input = sc.nextLine();

            if (isValidInput(input)) {
                int num = Integer.parseInt(input);
                list.add(num);
                sum += num;
            } else {
                System.out.println("输入无效，请输入整数。");
            }

        } while (sum < 200);

        System.out.println("输入总和大于等于200");
        sc.close();
    }

    private static boolean isValidInput(String input) {
        // 使用正则表达式验证输入是否为整数
        String integerPattern = "^-?\\d+$";
        return Pattern.matches(integerPattern, input);
    }
}
