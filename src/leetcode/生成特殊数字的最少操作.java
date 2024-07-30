package leetcode;

import java.math.BigInteger;
import java.util.*;

public class 生成特殊数字的最少操作 {
    public static void main(String[] args) {
        System.out.println(minimumOperations("2245047"));
        System.out.println(removeDigit("1231", '1'));
    }

    public static int minimumOperations(String num) {
        Set<String> set = new HashSet<>();
        set.add("00");
        set.add("25");
        set.add("50");
        set.add("75");
        int min = num.contains("0") ? num.length() - 1 : num.length();
        for (int j = num.length() - 1; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                if (set.contains("" + num.charAt(i) + num.charAt(j))) {
                    min = Math.min((num.length() - 1 - j) + (j - i - 1), min);
                }
            }
        }
        return min;
    }


    //提了点速
    //遇到关键数字加入答案集合，凑够两个关键数字得出答案
    public int minimumOperations2(String num) {
        int n = num.length();
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                if (set.contains('0')) {
                    return n - i - 2;
                } else {
                    set.add('0');
                }
                count++;
            }
            if (num.charAt(i) == '2') {
                if (set.contains('5')) {
                    return n - i - 2;
                }
            }
            if (num.charAt(i) == '5') {
                if (set.contains('0')) {
                    return n - i - 2;
                } else {
                    set.add('5');
                }
            }
            if (num.charAt(i) == '7') {
                if (set.contains('5')) {
                    return n - i - 2;
                }
            }
        }
        return n - count;
    }

    //给你一个表示某个正整数的字符串 number 和一个字符 digit 。
    //
    //从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
    //
    //
    //
    //示例 1：
    //
    //输入：number = "123", digit = "3"
    //输出："12"
    //解释："123" 中只有一个 '3' ，在移除 '3' 之后，结果为 "12" 。
    //示例 2：
    //
    //输入：number = "1231", digit = "1"
    //输出："231"
    //解释：可以移除第一个 '1' 得到 "231" 或者移除第二个 '1' 得到 "123" 。
    //由于 231 > 123 ，返回 "231" 。
    //示例 3：
    //
    //输入：number = "551", digit = "5"
    //输出："51"
    //解释：可以从 "551" 中移除第一个或者第二个 '5' 。
    //两种方案的结果都是 "51" 。
    public static String removeDigit(String number, char digit) {
        String ans = "-1";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String temp = number.substring(0, i).concat(number.substring(i + 1));
                if (new BigInteger(temp).compareTo(new BigInteger(ans)) > 0) ans = temp;
            }
        }
        return ans;
    }

    //高速做法
    public String removeDigit2(String number, char digit) {
        int n = number.length(), removeIdx = -1;
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                removeIdx = i;
                if (i == n - 1 || digit < number.charAt(i + 1))
                    break;//在要移除的这一位时，如果移除了，后一位比移除的数大，这肯定是最大结果，比如145....不移除:145...，移除:15....
            }
        }
        return number.substring(0, removeIdx) + number.substring(removeIdx + 1);
    }


/*给你一个下标从 0 开始的字符串 num ，表示一个非负整数。

在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。

返回最少需要多少次操作可以使 num 变成特殊数字。

如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。





示例 1：

输入：num = "2245047"
输出：2
解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 2 位数字。
示例 2：

输入：num = "2908305"
输出：3
解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 3 位数字。
示例 3：

输入：num = "10"
输出：1
解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 1 位数字。*/


//又一简单题
/*给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。

混合字符串 由小写英文字母和数字组成。



示例 1：

输入：s = "dfa12321afd"
输出：2
解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
示例 2：

输入：s = "abc1111"
输出：-1
解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。*/

    public static int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            int num = c - '0';
            if (num >= 0 && num <= 9) {
                set.add(num);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.size() > 1 ? list.get(list.size() - 2) : -1;
    }


}