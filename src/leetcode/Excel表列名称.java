package leetcode;

public class Excel表列名称 {
    public static void main(String[] args) {
        int columnNumber = 2147483647;
        int num=701;
        System.out.println(convertToTitle(52));
        System.out.println(titleToNumber(convertToTitle1(701)));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        int mo=-1;
        while (columnNumber > 0) {
            if(columnNumber==1&&mo==0)break;
            mo = columnNumber % 26;
            columnNumber /= 26;
            char ch;
            if (mo != 0) {
                ch = (char) ('A' + mo - 1);
                sb.append(ch);
            } else {
                sb.append('Z');
            }
        }
        return sb.reverse().toString();
    }

    //抄的

    /*作者：力扣官方题解
    链接：https://leetcode.cn/problems/excel-sheet-column-title/solutions/849363/excelbiao-lie-ming-cheng-by-leetcode-sol-hgj4/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public static String convertToTitle1(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();


    }

    public static int titleToNumber(String columnTitle) {
        int num=0;
        int n=columnTitle.length();
        for (int i = n-1; i >= 0; i--) {
            num+=Math.pow(26,n-1-i)*(columnTitle.charAt(i)-'A'+1);
        }
        return num;
    }

    public int titleToNumber2(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = ans*26+(columnTitle.charAt(i)-'A'+1);//*26相当于左移一位，相当于10进制*10
        }
        return ans;
    }
}

/*
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

例如：

A -> 1
B -> 2
C -> 3
        ...
Z -> 26
AA -> 27
AB -> 28
        ...


示例 1：

输入：columnNumber = 1
输出："A"
示例 2：

输入：columnNumber = 28
输出："AB"
示例 3：

输入：columnNumber = 701
输出："ZY"
示例 4：

输入：columnNumber = 2147483647
输出："FXSHRXW"*/
