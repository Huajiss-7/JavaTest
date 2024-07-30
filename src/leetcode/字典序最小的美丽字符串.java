package leetcode;


//困难
public class 字典序最小的美丽字符串 {
    public static void main(String[] args) {
        String s="abcz";
        System.out.println(smallestBeautifulString(s, 26));
    }

    //抄的
    public static String smallestBeautifulString(String str, int k) {
        k+='a';//k进制，以下字符全部换成ASCII码来看
        char[]s = str.toCharArray();
        int i=s.length-1;//从最后一个字母开始
        s[i]++;//先加一
        while (i<s.length) {
            if (s[i]==k) {//需要进位
                if(i==0)return "";//无法进位
                //进位
                s[i]='a';
                i--;
                s[i]++;//相当于9+1->1 0
            } else if (i>0&&s[i]==s[i-1]||i-1>0&&s[i]==s[i-2]) {//全部进位完之后才会开始执行检查回文
                //保证不出现长度为2或3的回文就不会有回文
                //因为进位只会进位到第i位，也就是可能引起出现回文的发生变化的字符只会发生在第i位之后，所以从第i位开始向后检查，先检查i的左侧
                s[i]++;// 如果 s[i] 和左侧的字符形成回文串，就继续增加 s[i]，可能再次造成进位
            }else {
                i++;//再检查右侧
            }
        }
        return new String(s);
    }
}

/*
如果一个字符串满足以下条件，则称其为 美丽字符串 ：

它由英语小写字母表的前 k 个字母组成。
它不包含任何长度为 2 或更长的回文子字符串。
给你一个长度为 n 的美丽字符串 s 和一个正整数 k 。

请你找出并返回一个长度为 n 的美丽字符串，该字符串还满足：在字典序大于 s 的所有美丽字符串中字典序最小。如果不存在这样的字符串，则返回一个空字符串。

对于长度相同的两个字符串 a 和 b ，如果字符串 a 在与字符串 b 不同的第一个位置上的字符字典序更大，则字符串 a 的字典序大于字符串 b 。

例如，"abcd" 的字典序比 "abcc" 更大，因为在不同的第一个位置（第四个字符）上 d 的字典序大于 c 。


示例 1：

输入：s = "abcz", k = 26
输出："abda"
解释：字符串 "abda" 既是美丽字符串，又满足字典序大于 "abcz" 。
可以证明不存在字符串同时满足字典序大于 "abcz"、美丽字符串、字典序小于 "abda" 这三个条件。
示例 2：

输入：s = "dc", k = 4
输出：""
解释：可以证明，不存在既是美丽字符串，又字典序大于 "dc" 的字符串。*/
