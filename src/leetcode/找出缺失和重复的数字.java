package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 找出缺失和重复的数字 {
    public static void main(String[] args) {
        int[][]grid={{9,1,7},
                     {8,9,2},
                     {3,4,6}};
        for (int value : findMissingAndRepeatedValues(grid)) {
            System.out.print(value+" ");
        }
    }

    //改进版
    public int[] findMissingAndRepeatedValues1(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1];
        for (int[] row : grid) {
            for (int x : row) {
                cnt[x]++;
            }
        }

        int[] ans = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (cnt[i] == 2) {
                ans[0] = i; // 出现两次的数
            } else if (cnt[i] == 0) {
                ans[1] = i; // 出现零次的数
            }
        }
        return ans;
    }


    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[]ans=new int[2];
        int n=grid.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n*n;i++){
            map.put(i,0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j],map.get(grid[i][j])+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==2){
                ans[0]=entry.getKey();
            }
            if(entry.getValue()==0){
                ans[1]=entry.getKey();
            }
        }
        return ans;
    }
}

/*给你一个下标从 0 开始的二维整数矩阵 grid，大小为 n * n ，其中的值在 [1, n2] 范围内。除了 a 出现 两次，b 缺失 之外，每个整数都 恰好出现一次 。

        任务是找出重复的数字a 和缺失的数字 b 。

        返回一个下标从 0 开始、长度为 2 的整数数组 ans ，其中 ans[0] 等于 a ，ans[1] 等于 b 。



        示例 1：

        输入：grid = [[1,3],[2,2]]
        输出：[2,4]
        解释：数字 2 重复，数字 4 缺失，所以答案是 [2,4] 。
        示例 2：

        输入：grid = [[9,1,7],[8,9,2],[3,4,6]]
        输出：[9,5]
        解释：数字 9 重复，数字 5 缺失，所以答案是 [9,5] 。*/
