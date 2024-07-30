package leetcode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//困难
public class 矩阵中严格递增的单元格数 {
    public static void main(String[] args) {
        int[][]matrix = {{3, 1, 6},
                         {-9, 5, 7}};
        System.out.println(maxIncreasingCells2(matrix));
    }

    //动态规划，抄的
    public static int maxIncreasingCells2(int[][] matrix) {
        TreeMap<Integer,ArrayList<int[]>> map = new TreeMap<>();//记录矩阵的值的位置，从小到大排序
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                map.computeIfAbsent(matrix[i][j],k->new ArrayList<>()).add(new int[]{i,j});
            }
        }

        int[]maxOfRow=new int[matrix.length];
        int[] maxOfCol=new int[matrix[0].length];
        //int curmax=0;//当前点的最大值
        int ans=0;
        for (Map.Entry<Integer, ArrayList<int[]>> entry : map.entrySet()) {
            int[]fs=new int[entry.getValue().size()];
            for (int i = 0; i < entry.getValue().size(); i++) {
                int row=entry.getValue().get(i)[0];
                int col=entry.getValue().get(i)[1];
                fs[i]=Math.max(maxOfCol[col],maxOfRow[row])+1;
                ans=Math.max(ans,fs[i]);
            }

            for (int i = 0; i < entry.getValue().size(); i++) {
                int row=entry.getValue().get(i)[0];
                int col=entry.getValue().get(i)[1];
                maxOfRow[row]=Math.max(maxOfRow[row],fs[i]);
                maxOfCol[col]=Math.max(maxOfCol[col],fs[i]);
            }
        }
        return ans;
    }


    //自己写的暴力
    public static int maxIncreasingCells(int[][] mat) {
        ArrayList<Integer> list = new ArrayList<>();//记录所有走投无路的值
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dfs(mat,mat[i][j],i,j,1,list);
            }
        }

        int max=0;
        for (Integer integer : list) {
            System.out.println(integer);
            max=Math.max(max,integer);
        }
        return max;
    }

    private static void dfs(int[][] mat, int nowVal,int row, int col, int count,ArrayList<Integer> list) {
        if(row+1<mat.length&&nowVal<mat[row+1][col]){
            dfs(mat,mat[row+1][col],row+1,col,count+1,list);
        }
        if(row-1>=0&&nowVal<mat[row-1][col]){
            dfs(mat,mat[row-1][col],row-1,col,count+1,list);
        }
        if(col+1<mat[0].length&&nowVal<mat[row][col+1]){
            dfs(mat,mat[row][col+1],row,col+1,count+1,list);
        }
        if(col-1>=0&&nowVal<mat[row][col-1]){
            dfs(mat,mat[row][col-1],row,col-1,count+1,list);
        }
        if ((row == 0 || nowVal <= mat[row - 1][col]) && // Check upper boundary or condition
                (row == mat.length - 1 || nowVal <= mat[row + 1][col]) && // Check lower boundary or condition
                (col == 0 || nowVal <= mat[row][col - 1]) && // Check left boundary or condition
                (col == mat[0].length - 1 || nowVal <= mat[row][col + 1])) { // Check right boundary or condition
            list.add(count);
        }

    }


    //GPT的暴力
    public static int maxIncreasingCells1(int[][] mat) {
        ArrayList<Integer> list = new ArrayList<>(); // 记录所有走投无路的值
        int[][] memo = new int[mat.length][mat[0].length]; // 缓存

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dfs1(mat, i, j, memo, list);
            }
        }

        int max = 0;
        for (Integer integer : list) {
            System.out.println(integer);
            max = Math.max(max, integer);
        }
        return max;
    }

    private static int dfs1(int[][] mat, int row, int col, int[][] memo, ArrayList<Integer> list) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int maxCount = 1;
        int nowVal = mat[row][col];

        if (row + 1 < mat.length && nowVal < mat[row + 1][col]) {
            maxCount = Math.max(maxCount, 1 + dfs1(mat, row + 1, col, memo, list));
        }
        if (row - 1 >= 0 && nowVal < mat[row - 1][col]) {
            maxCount = Math.max(maxCount, 1 + dfs1(mat, row - 1, col, memo, list));
        }
        if (col + 1 < mat[0].length && nowVal < mat[row][col + 1]) {
            maxCount = Math.max(maxCount, 1 + dfs1(mat, row, col + 1, memo, list));
        }
        if (col - 1 >= 0 && nowVal < mat[row][col - 1]) {
            maxCount = Math.max(maxCount, 1 + dfs1(mat, row, col - 1, memo, list));
        }

        // 如果当前节点是终点，记录路径长度
        if ((row == 0 || nowVal >= mat[row - 1][col]) &&
                (row == mat.length - 1 || nowVal >= mat[row + 1][col]) &&
                (col == 0 || nowVal >= mat[row][col - 1]) &&
                (col == mat[0].length - 1 || nowVal >= mat[row][col + 1])) {
            list.add(maxCount);
        }

        memo[row][col] = maxCount; // 缓存结果
        return maxCount;
    }
}

/*
给你一个下标从 1 开始、大小为 m x n 的整数矩阵 mat，你可以选择任一单元格作为 起始单元格 。

从起始单元格出发，你可以移动到 同一行或同一列 中的任何其他单元格，但前提是目标单元格的值 严格大于 当前单元格的值。

你可以多次重复这一过程，从一个单元格移动到另一个单元格，直到无法再进行任何移动。

请你找出从某个单元开始访问矩阵所能访问的 单元格的最大数量 。

返回一个表示可访问单元格最大数量的整数。



示例 1：



输入：mat = [[3,1],[3,4]]
输出：2
解释：上图展示了从第 1 行、第 2 列的单元格开始，可以访问 2 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 2 个单元格，因此答案是 2 。
示例 2：



输入：mat = [[1,1],[1,1]]
输出：1
解释：由于目标单元格必须严格大于当前单元格，在本示例中只能访问 1 个单元格。
示例 3：



输入：mat = [[3,1,6],[-9,5,7]]
输出：4
解释：上图展示了从第 2 行、第 1 列的单元格开始，可以访问 4 个单元格。可以证明，无论从哪个单元格开始，最多只能访问 4 个单元格，因此答案是 4 。
 */
