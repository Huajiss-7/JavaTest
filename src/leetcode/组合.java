package leetcode;

import java.util.ArrayList;
import java.util.List;

//自己做的第100道leetcode题
public class 组合 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        dfs(1,0,n,k,list,ans);
        return ans;
    }

    private static void dfs(int begin,int count,int n,int k,List<Integer>list,List<List<Integer>>ans){
        if(count==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= n; i++) {
            list.add(i);
            dfs(i+1,count+1,n,k,list,ans);
            list.removeLast();
        }
    }
}

    /*给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

        你可以按 任何顺序 返回答案。



        示例 1：

        输入：n = 4, k = 2
        输出：
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]
        示例 2：

        输入：n = 1, k = 1
        输出：[[1]]*/