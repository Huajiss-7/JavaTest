package leetcode;

public class 快乐数 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {//如果一个数不是快乐数，它一定陷入了循环
        if(n<=0)return false;//只有正整数可能是快乐数
        int fast=getChange(n);//记录每次变化两次的结果
        int slow=n;//记录每次变化一次的结果
        while (fast!=1&&slow!=1){
            slow=getChange(slow);
            fast=getChange(getChange(fast));
            if(fast==slow&&fast!=1)return false;
        }
        return true;
    }

    public static int getChange(int n){
        int sum=0;
        while (n>0){
            sum+=(n%10)*(n%10);//不加括号，就是从左到右顺序计算，出bug
            n=n/10;
        }
        return sum;
    }
}


    /*编写一个算法来判断一个数 n 是不是快乐数。

        「快乐数」 定义为：

        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。



        示例 1：

        输入：n = 19
        输出：true
        解释：
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1
        示例 2：

        输入：n = 2
        输出：false*/