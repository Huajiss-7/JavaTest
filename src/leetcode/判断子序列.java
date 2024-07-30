package leetcode;

public class 判断子序列 {
    public static void main(String[] args) {
        String s="aertbmgc";
        String t="abc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int traceS=0;
        int traceT=0;
        while (traceS<s.length()&&traceT<t.length()){
            if(s.charAt(traceS)==t.charAt(traceT)){
                traceS++;
                traceT++;
            }else {
                traceT++;
            }
        }
        return traceS==s.length();
    }
}

    /*给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

        字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

        进阶：

        如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

        致谢：

        特别感谢 @pbrother 添加此问题并且创建所有测试用例。



        示例 1：

        输入：s = "abc", t = "ahbgdc"
        输出：true
        示例 2：

        输入：s = "axc", t = "ahbgdc"
        输出：false*/
