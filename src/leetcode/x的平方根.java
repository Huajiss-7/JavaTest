package leetcode;

public class x的平方根 {
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }

    public static int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));//根号x，等于x的二分之一次方，等于e的lnx次方的二分之一次方，等于e的二分之一乘上lnx次方
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;


    }


    //自己写的
    public static int mySqrt(int x) {
        //if(x==4)return 2;
        if(x==1)return 1;
        for (long i = 0; i <= x/2+1; i++) {
            if(i*i>x)return (int)i-1;//防溢出,i*i超过int
        }
        return 0;
    }
}

    /*给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

        由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。



        示例 1：

        输入：x = 4
        输出：2
        示例 2：

        输入：x = 8
        输出：2
        解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。*/
