package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 赎金信 {
    public static void main(String[] args) {
        String s1="aa";
        String s2="aab";
        System.out.println(canConstruct(s1, s2));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length())return false;
        Map<Character,Integer>map=new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c:ransomNote.toCharArray()){
            if(map.get(c)==null||map.get(c)==0)return false;
            map.put(c,map.get(c)-1);
        }
        return true;
    }
}


/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

        如果可以，返回 true ；否则返回 false 。

        magazine 中的每个字符只能在 ransomNote 中使用一次。



        示例 1：

        输入：ransomNote = "a", magazine = "b"
        输出：false
        示例 2：

        输入：ransomNote = "aa", magazine = "ab"
        输出：false
        示例 3：

        输入：ransomNote = "aa", magazine = "aab"
        输出：true*/
