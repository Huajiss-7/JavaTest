package leetcode;

public class 找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        String caodui="ababcabbaacba";
        String zhen="abb";
        System.out.println(strStr3(caodui, zhen));
    }

    //KMP算法
    //自己写的
    public static int strStr3(String s,String t){
        //求next数组
        int[] next = new int[t.length() + 1];
        next[1] = 0;
        int i = 1, j = 0;//i是后缀，j是前缀
        while (i < t.length()) {
            if (j == 0 || t.charAt(i) == t.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        int i1 = 0, j1 = 0;
        //求完了next数组
        while (i1 < s.length() && j1 < t.length()) {
            if (j1 == 0 || s.charAt(i1) == t.charAt(j1)) {
                i1++;
                j1++;
            } else {
                j1 = next[j1];
            }
        }
        if (j1 == t.length()) return i1 - j1;
        else return -1;
    }
    public static int strStr2(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }


    //暴力法
    public static int strStr(String haystack, String needle) {
        int index=-1;
        for (int i = 0,j=0; i < haystack.length(); ) {
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    index=i-j;
                    break;
                }
            }else {
                i=i-j+1;
                j=0;
            }
        }
        return index;
    }

    //库方法
    public static int strStr1(){
        String str = "Hello, world!";
        String subStr = "world";
        int index = str.indexOf(subStr);

        if (index != -1) {
            System.out.println("子串在字符串中的位置是：" + index);
        } else {
            System.out.println("字符串中不包含该子串");
        }
        return index;
    }
}

   /* 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。



        示例 1：

        输入：haystack = "sadbutsad", needle = "sad"
        输出：0
        解释："sad" 在下标 0 和 6 处匹配。
        第一个匹配项的下标是 0 ，所以返回 0 。
        示例 2：

        输入：haystack = "leetcode", needle = "leeto"
        输出：-1
        解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。*/
