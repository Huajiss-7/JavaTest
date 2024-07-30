package leetcode;

public class 验证回文串 {
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c))sb.append(c);
        }
        if(sb.toString().toUpperCase().equals(sb.reverse().toString().toUpperCase()))return true;
        else return false;
    }

    public static boolean isPalindrome1(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}

/*如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

        字母和数字都属于字母数字字符。

        给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。



        示例 1：

        输入: s = "A man, a plan, a canal: Panama"
        输出：true
        解释："amanaplanacanalpanama" 是回文串。
        示例 2：

        输入：s = "race a car"
        输出：false
        解释："raceacar" 不是回文串。
        示例 3：

        输入：s = " "
        输出：true
        解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
        由于空字符串正着反着读都一样，所以是回文串。*/
