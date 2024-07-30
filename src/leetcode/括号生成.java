package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }




    public static List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);//比如从头开始先((( 然后))) 之后下面close<open的递归结束，然后依次往回退删除最右边，直到变成(((，然后结束(((的递归，变成((之后走下面,就是先搜索(((的所有匹配情况，然后结束后退回((走下面，再探索((所有匹配情况，依次回溯，相当于对每一种情况都走到头，然后恢复比如()()先探索所有满足情况，然后退回()(再探索
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }



    //有bug，不会改，QAQ
    //有可能是忘了回溯了，dfs后删除之前的值，懒得试是不是这个原因
    public static List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        dfs(n,"(","",0,0,ans,n);
        return ans;
    }

    public static void dfs(int n,String parenth,String now,int leftCount,int rightCount,List<String>ans,int max){
        if(n==0){
            ans.add(now);
            return;
        }
        if(rightCount>max||leftCount>max)return;//不能用n，n会变
        if(parenth.equals("(")){
            now+=parenth;
            leftCount++;
            //if(rightCount==leftCount)n-=1;  这样左先到3，右永远不等 (((
            if(leftCount>=rightCount)n=n-rightCount;
            else return;
            dfs(n,"(",now,leftCount,rightCount,ans,max);
            dfs(n,")",now,leftCount,rightCount,ans,max);
        }else {
            now+=parenth;
            rightCount++;
            //if(rightCount==leftCount)n-=1;
            if(leftCount>=rightCount)n=n-rightCount;
            else return;
            dfs(n,"(",now,leftCount,rightCount,ans,max);
            dfs(n,")",now,leftCount,rightCount,ans,max);
        }
    }
}

    /*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



        示例 1：

        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]
        示例 2：

        输入：n = 1
        输出：["()"]*/