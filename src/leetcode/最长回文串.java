package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 最长回文串 {
    public static void main(String[] args) {
        String s="abccccdd";
        System.out.println(longestPalindrome1(s));
    }

    public static int longestPalindrome1(String s) {
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean hasOdd = false; // 标记是否存在出现次数为奇数的字符
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int count = entry.getValue();
            if (count % 2 == 0) {
                ans += count;
            } else {
                ans += count - 1; // 出现奇数次的字符，可以取偶数个
                hasOdd = true;
            }
        }
        if (hasOdd) {
            ans++; // 如果存在出现次数为奇数的字符，可以作为回文字符串的中心
        }
        return ans;
    }


    //自己写的，中心字符处理有问题
    public static int longestPalindrome(String s) {
        int ans=1;
        HashMap<Character,Integer>hm=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        if(hm.size()==1&&hm.get(s.charAt(0))>1){//应对全部字符都一样的字符串
            return hm.get(s.charAt(0));
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if(entry.getValue()>1){
                if(entry.getValue()%2==0){
                    ans+=entry.getValue();
                }else {
                    ans+=entry.getValue()-1;
                }
            }
        }
        return ans;
    }
}

    /*给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。

        在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。



        示例 1:

        输入:s = "abccccdd"
        输出:7
        解释:
        我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
        示例 2:

        输入:s = "a"
        输出:1
        示例 3：

        输入:s = "aaaaaccc"
        输出:7*/