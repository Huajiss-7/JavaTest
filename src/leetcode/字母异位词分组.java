package leetcode;

import java.util.*;

public class 字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs).forEach(System.out::println);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。



示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
示例 2:

输入: strs = [""]
输出: [[""]]
示例 3:

输入: strs = ["a"]
输出: [["a"]]*/
