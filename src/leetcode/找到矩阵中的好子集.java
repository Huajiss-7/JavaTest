package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 找到矩阵中的好子集 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0},
                        {0, 0, 0, 1},
                        {1, 1, 1, 1}};
        System.out.println(goodSubsetofBinaryMatrix(grid));
    }


    /*可以证明，如果存在一个好的行子集，那么就存在一个大小为 1 或 2 的好的行子集。
    要检查是否存在一个大小为 1 的好的行子集，我们检查是否存在只包含零的行，如果是，我们将其索引作为好的子集返回。
    要检查是否存在一个大小为 2 的好的行子集，我们迭代两个位掩码，检查两者是否都出现在数组中，以及它们是否形成一个好的子集，如果是，则将其索引作为好的子集返回。*/
    public static List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        if(grid.length==1){
            for(int i=0; i<grid[0].length; i++){
                if(grid[0][i]==1){return ans;}
            }
            ans.add(0);
            return ans;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {//选一行
            for (int j = i + 1; j < m; j++) {//选另一行
                boolean flag = true;
                for (int k = 0; k < n; k++) {//遍历这两行
                    if ((grid[i][k] & grid[j][k]) == 1) {
                        flag=false;
                        break;
                    }
                }
                if (flag) {
                    ans.add(i);
                    ans.add(j);
                    return ans;
                }
            }
        }
        return ans;
    }
}



/*
给你一个下标从 0 开始大小为 m x n 的二进制矩阵 grid 。

从原矩阵中选出若干行构成一个行的 非空 子集，如果子集中任何一列的和至多为子集大小的一半，那么我们称这个子集是 好子集。

更正式的，如果选出来的行子集大小（即行的数量）为 k，那么每一列的和至多为 floor(k / 2) 。

请你返回一个整数数组，它包含好子集的行下标，请你将其 升序 返回。

如果有多个好子集，你可以返回任意一个。如果没有好子集，请你返回一个空数组。

一个矩阵 grid 的行 子集 ，是删除 grid 中某些（也可能不删除）行后，剩余行构成的元素集合。



示例 1：

输入：grid = [[0,1,1,0],[0,0,0,1],[1,1,1,1]]
输出：[0,1]
解释：我们可以选择第 0 和第 1 行构成一个好子集。
选出来的子集大小为 2 。
        - 第 0 列的和为 0 + 0 = 0 ，小于等于子集大小的一半。
        - 第 1 列的和为 1 + 0 = 1 ，小于等于子集大小的一半。
        - 第 2 列的和为 1 + 0 = 1 ，小于等于子集大小的一半。
        - 第 3 列的和为 0 + 1 = 1 ，小于等于子集大小的一半。
示例 2：

输入：grid = [[0]]
输出：[0]
解释：我们可以选择第 0 行构成一个好子集。
选出来的子集大小为 1 。
        - 第 0 列的和为 0 ，小于等于子集大小的一半。
示例 3：

输入：grid = [[1,1,1],[1,1,1]]
输出：[]
解释：没有办法得到一个好子集。
grid[i][j] 要么是 0 ，要么是 1 。*/
