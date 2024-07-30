package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 整数转罗马数字 {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
        String roman = "MCMXCIV";
        System.out.println(romanToInt(roman));
    }

    public static String intToRoman(int num) {
        String[] romanSymbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String ans = "";
        for (int i = 0; i < value.length; i++) {
            if (num >= value[i]) {//贪心，每次都取能用的最大值，直到为0
                num -= value[i];
                ans += romanSymbol[i];
                i--;//有可能剩下的值还可以用相同的符号表示，但不可能用之前更大的符号表示
            }
        }
        return ans;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int num = symbolValues.get(s.charAt(s.length()-1));
        for (int i = s.length()-2; i >= 0; i--) {
            if(symbolValues.get(s.charAt(i))>=symbolValues.get(s.charAt(i+1))){//左边的数比右边的数小，表示当前数要减去这个数
                num+=symbolValues.get(s.charAt(i));
            }else {
                num-=symbolValues.get(s.charAt(i));
            }
        }
        return num;
    }
}



/*罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        给你一个整数，将其转为罗马数字。

        输入: num = 1994
        输出: "MCMXCIV"
        解释: M = 1000, CM = 900, XC = 90, IV = 4.*/
