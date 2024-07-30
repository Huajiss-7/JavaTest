package leetcode;

public class 快速幂 {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }

//https://leetcode.cn/problems/powx-n/solutions/2858114/tu-jie-yi-zhang-tu-miao-dong-kuai-su-mi-ykp3i/
    public static double myPow(double x, int N) {
        long n=N;
        double ans = 1;
        if(n<0){
            x = 1 / x;
            n = -n;
        }
        while (n>0){
            if(n%2==1){//或 n&1==1
                ans = ans * x;
            }
            x = x * x;
            n = n / 2;
        }
        return ans;
    }
}

/*
实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。



示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25*/
