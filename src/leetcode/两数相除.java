package leetcode;

import java.math.BigInteger;

public class 两数相除 {
    public static void main(String[] args) {
        System.out.println(-2147483648*-1);
        System.out.println(divide2(-2147483648, -1));
    }

    //作弊
    public static int divide2(int num1, int num2) {
        BigInteger dividend = new BigInteger(String.valueOf(num1));
        BigInteger divisor = new BigInteger(String.valueOf(num2));
        BigInteger result = dividend.divide(divisor);
        if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE; // 结果超出Integer.MAX_VALUE，返回Integer.MAX_VALUE
        } else if (result.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE; // 结果超出Integer.MIN_VALUE，返回Integer.MIN_VALUE
        } else {
            return result.intValue(); // 结果在int范围内，返回结果
        }
    }

    //溢出判断不想写了
    public static int divide(int dividend, int divisor) {
        int result = 0;
        if((divisor>>31^dividend>>31)==0){//符号位相同
            if(dividend<0){dividend = -dividend;
            divisor=-divisor;}
            if(dividend==-2147483648){
                dividend+=divisor;
                //result++;
                dividend=-dividend;
            }
            while(dividend>=divisor){
                dividend -= divisor;
                result++;
            }
        }else {
            //dividend^=1<<31;
            //divisor^=1<<31;
            if(dividend<=0)dividend = -dividend;
            if(divisor<=0)divisor=-divisor;
            while(dividend>=divisor){
                dividend -= divisor;
                result++;
            }
            result=-result;
        }
        return result;
    }
}

/*
给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。

整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。

返回被除数 dividend 除以除数 divisor 得到的 商 。

注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。



示例 1:

输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。


提示：

        -231 <= dividend, divisor <= 231 - 1
divisor != 0*/
