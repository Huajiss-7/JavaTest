package leetcode;

public class 字符串转换整数 {
    public static void main(String[] args) {
        String s = "   -1234er1345";
        System.out.println(myAtoi("21474836460"));
    }

    //溢出截取前面的位数
    public static int myAtoi(String s) {
        s = s.trim();
        int symbol = 1, begin = 0;
        if (s.charAt(0) == '-') {
            symbol = -1;
            begin = 1;
        }
        while (s.charAt(begin)==0){
            begin++;
        }
        if(!isDigit(s.charAt(begin)))return 0;
        StringBuffer sb=new StringBuffer();
        while (isDigit(s.charAt(begin))){
            sb.append(s.charAt(begin));
            begin++;
            if(begin==s.length())break;
        }
        String ans=sb.toString();
        if(ans.length()>10){//超过10位就肯定超过int范围
            ans=ans.substring(0,10);
        }
        if(ans.length()==10&&Integer.parseInt(ans.substring(0,9))>=Integer.MAX_VALUE/10)ans=ans.substring(0,9);
        return symbol*Integer.parseInt(ans);
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }





    //溢出取最大值
    /*public static int myAtoi(String s) {
        if(s.isEmpty()||s.equals(" "))return 0;
        s = s.trim();
        int symbol = 1, begin = 0;
        if (s.charAt(0) == '-') {
            if(s.length()==1)return 0;
            symbol = -1;
            begin = 1;
        }
        if(s.charAt(0) == '+'){if(s.length()==1)return 0;begin=1;}
        while (s.charAt(begin)==0){
            begin++;
        }
        if(!isDigit(s.charAt(begin)))return 0;
        StringBuffer sb=new StringBuffer();
        while (isDigit(s.charAt(begin))){
            sb.append(s.charAt(begin));
            begin++;
            if(begin==s.length())break;
        }
        //String ans=sb.toString();
        int ans = 0;
        for (char c : sb.toString().toCharArray()) {
            int digit = c - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {//判断加上digit是否会溢出，如果digit大于最大值的个位，一减就满足条件，否则不满足条件
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
        }

        return symbol*ans;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }*/

}


    /*请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

        函数 myAtoi(string s) 的算法如下：

        读入字符串并丢弃无用的前导空格
        检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
        如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
        返回整数作为最终结果。
        注意：

        本题中的空白字符只包括空格字符 ' ' 。
        除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。*/