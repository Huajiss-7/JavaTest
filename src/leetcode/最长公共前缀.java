package leetcode;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[]strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int min=strs[0].length();
        for (String str : strs) {
            min=Math.min(min,str.length());
        }//求出最短的那个字符串的长度

        String ans="";
        for (int i = 0; i < min; i++) {
            boolean flag=false;
            char c=strs[0].charAt(i);
            for (String str : strs){
                if(str.charAt(i)!=c){
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }else {
                ans+=c;
            }
        }
        return ans;
    }
}

/*
编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。



        示例 1：

        输入：strs = ["flower","flow","flight"]
        输出："fl"
        示例 2：

        输入：strs = ["dog","racecar","car"]
        输出：""
        解释：输入不存在公共前缀。*/
