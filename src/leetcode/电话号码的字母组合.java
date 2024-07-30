package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        dfs(digits.length(),digits,sb,ans);
        return ans;
    }

    public static void dfs(int len,String digits,StringBuilder now,List<String>ans){
        if(now.length()==len){
            ans.add(now.toString());
            return;
        }
        if(digits.length()==0)return;
        if(digits.charAt(0)=='2'){
            dfs(len,digits.substring(1),now.append("a"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("b"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("c"),ans);
            now.deleteCharAt(now.length()-1);
        }
        if(digits.charAt(0)=='3'){
            dfs(len,digits.substring(1),now.append("d"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("e"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("f"),ans);
            now.deleteCharAt(now.length()-1);
        }
        if(digits.charAt(0)=='4'){
            dfs(len,digits.substring(1),now.append("g"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("h"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("i"),ans);
            now.deleteCharAt(now.length()-1);
        }
        if(digits.charAt(0)=='5'){
            dfs(len,digits.substring(1),now.append("j"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("k"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("l"),ans);
            now.deleteCharAt(now.length()-1);
        }
        if(digits.charAt(0)=='6'){
            dfs(len,digits.substring(1),now.append("m"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("n"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("o"),ans);
            now.deleteCharAt(now.length()-1);
        }
        if(digits.charAt(0)=='7'){
            dfs(len,digits.substring(1),now.append("p"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("q"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("r"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("s"),ans);
            now.deleteCharAt(now.length()-1);
        }
        if(digits.charAt(0)=='8'){
            dfs(len,digits.substring(1),now.append("t"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("u"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("v"),ans);
            now.deleteCharAt(now.length()-1);
        }
        if(digits.charAt(0)=='9'){
            dfs(len,digits.substring(1),now.append("w"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("x"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("y"),ans);
            now.deleteCharAt(now.length()-1);
            dfs(len,digits.substring(1),now.append("z"),ans);
            now.deleteCharAt(now.length()-1);
        }

    }
}


/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





        示例 1：

        输入：digits = "23"
        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        示例 2：

        输入：digits = ""
        输出：[]
        示例 3：

        输入：digits = "2"
        输出：["a","b","c"]*/
