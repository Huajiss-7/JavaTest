package leetcode;

public class 执行子串操作后的字典序最小字符串 {
    public static void main(String[] args) {
        String s="aaadaaac";
        System.out.println(smallestString(s));
    }

    public static String smallestString(String s) {
        int indexOfFirstCharA=s.length();//没找到，就是没a，就整个字符串前移
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a'){
                indexOfFirstCharA=i;
                break;
            }
        }
        char[] charArray = s.toCharArray();

        if(indexOfFirstCharA==0){//第一个位置为a
            int notA=1;
            int indexOfSecondCharA=s.length();
            while (notA<s.length()&&s.charAt(notA)=='a'){
                notA++;
            }
            if(notA==s.length()){
                charArray[s.length()-1]='z';
                return String.valueOf(charArray);
            }//一定要执行一次，全是a就把最后变为z
            for (int i = notA; i < s.length(); i++) {
                if(s.charAt(i)=='a'){
                    indexOfSecondCharA=i;
                    break;
                }
            }
            for (int i=notA;i<indexOfSecondCharA;i++){
                charArray[i]--;
            }
            return String.valueOf(charArray);
        }

        for (int i = 0; i < indexOfFirstCharA; i++) {
            charArray[i]--;
        }
        return new String(charArray);
    }

    //抄的
    public String smallestString1(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (s[i] > 'a') {
                // 继续向后遍历
                for (; i < n && s[i] > 'a'; i++) {
                    s[i]--;
                }
                return new String(s);
            }
        }
        // 所有字母均为 a
        s[n - 1] = 'z';
        return new String(s);
    }
}

/*
给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：

选择 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。

子字符串 是字符串中的一个连续字符序列。

现有长度相同的两个字符串 x 和 字符串 y ，在满足 x[i] != y[i] 的第一个位置 i 上，如果  x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。


示例 1：

输入：s = "cbabc"
输出："baabc"
解释：我们选择从下标 0 开始、到下标 1 结束的子字符串执行操作。
可以证明最终得到的字符串是字典序最小的。
示例 2：

输入：s = "acbbc"
输出："abaab"
解释：我们选择从下标 1 开始、到下标 4 结束的子字符串执行操作。
可以证明最终得到的字符串是字典序最小的。
示例 3：

输入：s = "leetcode"
输出："kddsbncd"
解释：我们选择整个字符串执行操作。
可以证明最终得到的字符串是字典序最小的。*/
