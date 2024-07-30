package leetcode;

public class 最小路径和 {
    public static void main(String[] args) {
        int[][]grid={
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i==0&&j!=0)grid[i][j]+=grid[i][j-1];//第一行只有左侧
                else if(j==0&&i!=0)grid[i][j]+=grid[i-1][j];//第一列只有上侧
                else if(j==0&&i==0)continue;//原点
                else grid[i][j]+=Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[grid.length-1][grid[grid.length-1].length-1];
    }
}

   /* 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

        说明：每次只能向下或者向右移动一步。



        示例 1：


        输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        输出：7
        解释：因为路径 1→3→1→1→1 的总和最小。
        示例 2：

        输入：grid = [[1,2,3],[4,5,6]]
        输出：12*/
