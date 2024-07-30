package leetcode;

public class 检测大写字母 {
    public static void main(String[] args) {
        String word="leetCode";
        System.out.println(detectCapitalUse(word));
    }

    public static boolean detectCapitalUse(String word) {
        String lowerCase = word.toLowerCase();
        String upperCase = word.toUpperCase();
        if(word.equals(lowerCase) || word.equals(upperCase))return true;
        String substring = word.substring(0, 1);
        word = word.substring(1);
        if(substring.equals(substring.toUpperCase())&&word.equals(word.toLowerCase()))return true;
        return false;
    }
}

/*
我们定义，在以下情况时，单词的大写用法是正确的：

全部字母都是大写，比如 "USA" 。
单词中所有字母都不是大写，比如 "leetcode" 。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。



示例 1：

输入：word = "USA"
输出：true
示例 2：

输入：word = "FlaG"
输出：false*/
