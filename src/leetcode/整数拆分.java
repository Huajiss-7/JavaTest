package leetcode;

public class 整数拆分 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int[]dp=new int[n+1];//记录第i个数的最大拆分乘积
        dp[0]=dp[1]=0;//0和1不能拆分，不写也行，java中整数数组默认全0
        for (int i = 2; i <= n; i++) {
            int curMax=0;
            for (int j = 1; j < i; j++) {//把当前值i拆出的值j
                curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));//当前最大值为拆出j后j乘i-j不拆最大，或者j乘i-j继续拆最大
            }
            dp[i]=curMax;
        }
        return dp[n];
    }
}

    /*给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

        返回 你可以获得的最大乘积 。



        示例 1:

        输入: n = 2
        输出: 1
        解释: 2 = 1 + 1, 1 × 1 = 1。
        示例 2:

        输入: n = 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。*/
