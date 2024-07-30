package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 三角形最小路径和 {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer>row1=new ArrayList<>();
        List<Integer>row2=new ArrayList<>();
        List<Integer>row3=new ArrayList<>();
        List<Integer>row4=new ArrayList<>();
        Collections.addAll(row1,2);
        Collections.addAll(row2,3,4);
        Collections.addAll(row3,6,5,7);
        Collections.addAll(row4,4,1,8,3);
        Collections.addAll(triangle,row1,row2,row3,row4);
        System.out.println(minimumTotal1(triangle));
    }

    //超时
    public static int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle,0,0);//我们将任一点到底边的最小路径和，转化成了与该点相邻两点到底边的最小路径和中的较小
    }

    public static int dfs(List<List<Integer>> triangle,int i,int j){//i,j表示第i+1层，第j+1个（i,j是层和列的索引）
        if(i==triangle.size())return 0;
        return Math.min(dfs(triangle,i+1,j),dfs(triangle,i+1,j+1))+triangle.get(i).get(j);
    }

    //动态规划
    public static int minimumTotal1(List<List<Integer>> triangle) {
        //自底向上递推
        int n=triangle.size();
        int[][]dp=new int[n+1][n+1];//dp[i][j] 表示从点 (i,j) 到底边的最小路径和。
        for (int i = n-1; i >= 0; i--) {//i,j表示第i+1层，第j+1个（i,j是层和列的索引）
            for (int j = 0; j <= i; j++) {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

    /*给定一个三角形 triangle ，找出自顶向下的最小路径和。

        每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。



        示例 1：

        输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        输出：11
        解释：如下面简图所示：
        2
        3 4
        6 5 7
        4 1 8 3
        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
        示例 2：

        输入：triangle = [[-10]]
        输出：-10*/
