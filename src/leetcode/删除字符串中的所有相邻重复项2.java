package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 删除字符串中的所有相邻重复项2 {
    public static void main(String[] args) {
        String s="deeedbbcccbdaa";
        System.out.println(removeDuplicates3(s, 3));
    }

    public static String removeDuplicates3(String s, int k) {
        Deque<Character> stack = new ArrayDeque<Character>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int j=0;j<s.length();j++) {
            char c = s.charAt(j);
            if (!stack.isEmpty() && stack.peek() == c&&map.get(c) < k) {
                stack.push(c);
                map.put(c, map.get(c) + 1);
                if (map.get(c) == k) {
                    map.remove(c);
                    for(int i=0;i<k;i++){
                        stack.pop();
                    }
                }
            }/*else if(!stack.isEmpty() && stack.peek() == c&&map.get(c) == k){
                map.remove(c);
                for(int i=0;i<k;i++){
                    stack.pop();
                }
                //j--;
            }*/else {
                stack.push(c);
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    //逻辑错了，有以前不到k，但是重新归为1开始记录了
    public static String removeDuplicates(String s, int k) {
        Deque<Character> stack = new ArrayDeque<Character>();
        int count = 0;
        for (int j=0;j<s.length();j++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(j)&&count < k) {
                stack.push(s.charAt(j));
                count++;
            }else if(count == k){
                count=1;
                for(int i=0;i<k;i++){
                    stack.pop();
                }
                j--;
            }else {
                stack.push(s.charAt(j));
                count=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }



    public static String removeDuplicates2(String s, int k) {
        // Stack to store pairs of character and their counts
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();

        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            if (!stack.isEmpty() && stack.peek().getKey() == currentChar) {
                Pair<Character, Integer> top = stack.pop();
                int count = top.getValue() + 1;
                if (count < k) {
                    stack.push(new 删除字符串中的所有相邻重复项2().new Pair<>(currentChar, count));
                }
            } else {
                stack.push(new 删除字符串中的所有相邻重复项2().new Pair<>(currentChar, 1));//非静态内部类在静态方法中必须，用外部类.new出来，不然不知道内部类属于哪个外部实例,如果不写static可以直接用，因为默认是当前实例的内部类
            }
        }

        // Rebuild the string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> top = stack.pop();
            for (int i = 0; i < top.getValue(); i++) {
                sb.append(top.getKey());
            }
        }

        return sb.reverse().toString();
    }

    // Simple Pair class to store character and count
    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

/*
给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。

你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。

在执行完所有删除操作后，返回最终得到的字符串。

本题答案保证唯一。



示例 1：

输入：s = "abcd", k = 2
输出："abcd"
解释：没有要删除的内容。
示例 2：

输入：s = "deeedbbcccbdaa", k = 3
输出："aa"
解释：
先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
再删除 "bbb"，得到 "dddaa"
最后删除 "ddd"，得到 "aa"
示例 3：

输入：s = "pbbcggttciiippooaais", k = 2
输出："ps"*/
