package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 两句话中的不常见单词 {
    public static void main(String[] args) {
        String s1="this apple is sweet";
        String s2="this apple is sour";
        for (String s : uncommonFromSentences(s1, s2)) {
            System.out.println(s);
        }
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        Set<String>set=new HashSet<>();
        String[] split = (s1 +" "+ s2).split(" ");
        Set<String>moreThan2=new HashSet<>();
        for (String s : split) {
            if(moreThan2.contains(s))continue;
            if(!set.add(s)){
                set.remove(s);
                moreThan2.add(s);
            }
        }
        String[] ans = set.toArray(new String[0]);
        return ans;
    }
}

    /*句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。

        如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。

        给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。



        示例 1：

        输入：s1 = "this apple is sweet", s2 = "this apple is sour"
        输出：["sweet","sour"]
        示例 2：

        输入：s1 = "apple apple", s2 = "banana"
        输出：["banana"]


        提示：

        1 <= s1.length, s2.length <= 200
        s1 和 s2 由小写英文字母和空格组成
        s1 和 s2 都不含前导或尾随空格
        s1 和 s2 中的所有单词间均由单个空格分隔*/