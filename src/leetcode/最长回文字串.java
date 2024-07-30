package leetcode;

public class 最长回文字串 {
    public static void main(String[] args) {
        String s = "abcbadwre";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;//单个字符就是回文

        boolean[][] flag = new boolean[s.length()][s.length()];//记录字串是否为回文串，flag[i][j]表示下标第i个到第j个字符是回文串
        int begin=0,end=0;

        for (int i = 0; i < s.length(); i++) {
            flag[i][i] = true;//所有单个字符就是回文
        }//用不到flag[i][j] i>j的部分

        for (int L = 2; L <= s.length(); L++) {//L代表当前字串长度，从长度为2开始，一直到最大长度，遍历所有长度的字串
            for (int left = 0; left < s.length(); left++) {//从头遍历字符串，left为左界
                int right = left + L - 1;//left为从左界开始长度为L的右界
                if (right >= s.length()) break;//右界越界
                if (s.charAt(right) != s.charAt(left)) {
                    flag[left][right] = false;//如果，左边的字符不等右边的字符，则此串不是回文
                } else {//左界字符==右界字符
                    if(L<=3){
                        flag[left][right]=true;//双字符和三字符，如果两边字符相等就回文
                    }else {
                        flag[left][right]=flag[left+1][right-1];//检查这两个字符中间的串是否为回文，如果中间串是回文，此串就是回文
                    }
                }
                if(flag[left][right]){//如果此时为回文就记录，此回文串的位置，因为循环是从小到大，所以大回文的会覆盖小的回文
                    begin=left;
                    end=right;
                }
            }
        }

        return s.substring(begin,end+1);//substring包头不包尾所以end+1
    }
}

   /* 给你一个字符串 s，找到 s 中最长的回文
        子串
        。

        如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。



        示例 1：

        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。
        示例 2：

        输入：s = "cbbd"
        输出："bb"*/
