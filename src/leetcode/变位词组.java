package leetcode;

import java.util.*;

public class 变位词组 {
    public static void main(String[] args) {
        String[]strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans=new ArrayList<>();
        Map<String,List<String>>map=new HashMap<>();
        for (String str : strs) {
            char[]chars=str.toCharArray();
            Arrays.sort(chars);
            String s=new String(chars);//toString()方法并不能正确将其转换为字符串
            if(map.containsKey(s))map.get(s).add(str);
            else {
                ArrayList<String>list=new ArrayList<>();
                list.add(str);
                map.put(s,list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}


/*
编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。

        注意：本题相对原题稍作修改

        示例:

        输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
        输出:
        [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]
        说明：

        所有输入均为小写字母。
        不考虑答案输出的顺序。*/
