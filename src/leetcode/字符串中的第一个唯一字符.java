package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int index = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                map.put(c, -1);
            }
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) != -1) {
                index = map.get(c);
                break;
            }
        }
        return index;
    }
}

    /*给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。



        示例 1：

        输入: s = "leetcode"
        输出: 0
        示例 2:

        输入: s = "loveleetcode"
        输出: 2
        示例 3:

        输入: s = "aabb"
        输出: -1*/