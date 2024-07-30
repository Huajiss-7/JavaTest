package leetcode;

public class 爬楼梯 {
    public static void main(String[] args) {
        int n=10;
        System.out.println(climbStairs1(n));
    }

    public static int climbStairs1(int n) {
        if(n==1)return 1;
        int p,q=1,r=2;
        for (int i = 2; i < n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }


    //超时
    public static int climbStairs(int n) {
        if(n<1)return 0;//防止输入0和负数
        if(n==1)return 1;
        if(n==2)return 2;
        return climbStairs(n-1)+climbStairs(n-2);//n-1最后一步跨一阶的类型总数加上n-2最后一步跨二阶的类型总数
    }
}

/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？



        示例 1：

        输入：n = 2
        输出：2
        解释：有两种方法可以爬到楼顶。
        1. 1 阶 + 1 阶
        2. 2 阶
        示例 2：

        输入：n = 3
        输出：3
        解释：有三种方法可以爬到楼顶。
        1. 1 阶 + 1 阶 + 1 阶
        2. 1 阶 + 2 阶
        3. 2 阶 + 1 阶*/
