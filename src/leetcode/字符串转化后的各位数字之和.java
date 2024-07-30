package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 字符串转化后的各位数字之和 {
    public static void main(String[] args) {
        System.out.println((char)('a'-1));
        System.out.println('a'-'`');
        System.out.println("答案:"+getLucky("iiii", 1));
    }

    public static int getLucky(String s, int k) {
        List<Integer> list=new ArrayList();
        for (char c : s.toCharArray()) {
            list.add(c - '`');
        }
        int sum=getSum(list);
        for (int i = 0; i < k; i++) {
            sum=getSum(list);
            list.clear();
            fillList(String.valueOf(sum),list);
        }
        return sum;
    }

    private static void fillList(String s, List<Integer> list) {
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) - '0');
        }
    }

    private static int getSum(List<Integer> list) {
        int sum=0;
        for (Integer integer : list) {
            if(integer>=10){
                int gewei=integer%10;
                int shiwei=integer/10;
                sum+=gewei+shiwei;
            }
            else sum+=integer;
        }
        return sum;
    }

    public int getLucky2(String s, int k) {
        int n = s.length(), res = 0;
        //s转化数字，同步执行一次按位求和，k-1
        for(int i = 0; i < n; ++i){
            int num = s.charAt(i) - 'a' + 1;
            while(num > 0){
                res += num % 10;
                num /= 10;
            }
        }
        --k;
        //循环k-1次按位求和
        while(k > 0){
            int tem = res;
            res = 0;
            while(tem > 0){
                res += tem % 10;
                tem /= 10;
            }
            --k;
        }
        return res;
    }
}

/*
给你一个由小写字母组成的字符串 s ，以及一个整数 k 。

首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。

例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：

转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
转换 #2：17 ➝ 1 + 7 ➝ 8
返回执行上述操作后得到的结果整数。



示例 1：

输入：s = "iiii", k = 1
输出：36
解释：操作如下：
        - 转化："iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
        - 转换 #1：9999 ➝ 9 + 9 + 9 + 9 ➝ 36
因此，结果整数为 36 。
示例 2：

输入：s = "leetcode", k = 2
输出：6
解释：操作如下：
        - 转化："leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
        - 转换 #1：12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
        - 转换 #2：33 ➝ 3 + 3 ➝ 6
因此，结果整数为 6 。*/
