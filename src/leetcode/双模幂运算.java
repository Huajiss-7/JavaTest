package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 双模幂运算 {
    public static void main(String[] args) {
        int[][]variables = {{2,3,3,10},{3,3,3,1},{6,1,1,4}};
        System.out.println(getGoodIndices(variables, 2));
    }

    public List<Integer> getGoodIndices2(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if (pow(pow(v[0], v[1], 10), v[2], v[3]) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    // 本题 mod 很小，即使平方也不会超过 int 范围，所以不需要用 long
    private int pow(int x, int n, int mod) {
        int res = 1;
        while (n > 0) {
            if (n % 2 > 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n /= 2;
        }
        return res;
    }

    /*作者：灵茶山艾府
    链接：https://leetcode.cn/problems/double-modular-exponentiation/solutions/2560946/kuai-su-mi-pythonjavacgo-by-endlesscheng-xeth/
    */

    //精度不高，会溢出
    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a=variables[i][0];
            int b=variables[i][1];
            int c=variables[i][2];
            int m=variables[i][3];
            int calculate=(int)Math.pow(Math.pow(a,b)%10,c)%m;//这个在指数时会发生溢出，所以用溢出的数再取模会报错，所以要在指数运算过程中就取模
            if(calculate==target)list.add(i);
        }
        return list;
    }
}

/*
给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。

如果满足以下公式，则下标 i 是 好下标：

        0 <= i < variables.length
        ((aibi % 10)ci) % mi == target
返回一个由 好下标 组成的数组，顺序不限 。



示例 1：

输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
输出：[0,2]
解释：对于 variables 数组中的每个下标 i ：
        1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(23 % 10)3 % 10 = 2 。
        2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(33 % 10)3 % 1 = 0 。
        3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(61 % 10)1 % 4 = 2 。
因此，返回 [0,2] 作为答案。
示例 2：

输入：variables = [[39,3,1000,1000]], target = 17
输出：[]
解释：对于 variables 数组中的每个下标 i ：
        1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(393 % 10)1000 % 1000 = 1 。
因此，返回 [] 作为答案。*/
