package leetcode;

public class 二进制求和 {
    public static void main(String[] args) {
        String a="11";
        String b="1";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        if (a.length() == 0 || b.length() == 0) return (a.length() > b.length()) ? a : b;
        int carry = 0; // 进位
        int poa = a.length() - 1;
        int pob = b.length() - 1;
        String ans = "";
        while (poa >= 0 && pob >= 0) {
            if (a.charAt(poa) == '0' && b.charAt(pob) == '0' && carry == 0) {
                ans = "0" + ans;
            } else if (a.charAt(poa) == '0' && b.charAt(pob) == '0' && carry == 1) {
                ans = "1" + ans;
                carry = 0;
            } else if (a.charAt(poa) == '0' && b.charAt(pob) == '1' && carry == 0) {
                ans = "1" + ans;
            } else if (a.charAt(poa) == '1' && b.charAt(pob) == '0' && carry == 0) {
                ans = "1" + ans;
            } else if (a.charAt(poa) == '0' && b.charAt(pob) == '1' && carry == 1) {
                ans = "0" + ans;
            } else if (a.charAt(poa) == '1' && b.charAt(pob) == '0' && carry == 1) {
                ans = "0" + ans;
            } else if (a.charAt(poa) == '1' && b.charAt(pob) == '1' && carry == 0) {
                ans = "0" + ans;
                carry = 1;
            } else {
                ans = "1" + ans;
            }
            poa--;
            pob--;
        }
        while (poa >= 0) {
            if (a.charAt(poa) == '1' && carry == 1) {
                ans = "0" + ans;
                carry = 1;
            } else if (a.charAt(poa) == '0' && carry == 1) {
                ans="1"+ans;
                carry=0;
            } else {
                ans = a.charAt(poa) + ans;
            }
            poa--;
        }
        while (pob >= 0) {
            if (b.charAt(pob) == '1' && carry == 1) {
                ans = "0" + ans;
                carry = 1;
            } else if (b.charAt(pob) == '0' && carry == 1) {
                ans="1"+ans;
                carry=0;
            } else {
                ans = b.charAt(pob) + ans;
            }
            pob--;
        }
        if (carry == 1) {
            ans = "1" + ans;
        }
        return ans;
    }

    public static String addBinary1(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
    }

}

    /*给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。



        示例 1：

        输入:a = "11", b = "1"
        输出："100"
        示例 2：

        输入：a = "1010", b = "1011"
        输出："10101"*/
