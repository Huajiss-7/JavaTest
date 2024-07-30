package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class 找出第K大的异或坐标值 {
    public static void main(String[] args) {
        int[][]matrix={{5,2},
                       {1,6}};
        System.out.println(kthLargestValue1(matrix, 2));
    }


    public static int kthLargestValue1(int[][] matrix, int k) {
        int[][]pre=new int[matrix.length+1][matrix[0].length+1];
        ArrayList<Integer>list=new ArrayList<>();
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                pre[i][j]=pre[i-1][j]^pre[i][j-1]^pre[i-1][j-1]^matrix[i-1][j-1];
                list.add(pre[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(list.size()-k);
    }


    //理解错题目意思，以为是到这个下标为止所有的值来异或
    public static int kthLargestValue(int[][] matrix, int k) {
        int sum=0;
        ArrayList<Integer> list=new ArrayList<>();
        for (int[] row : matrix) {
            for (int elem : row) {
                sum^=elem;
                list.add(sum);
            }
        }
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}

    /*给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。

        矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。

        请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。



        示例 1：

        输入：matrix = [[5,2],[1,6]], k = 1
        输出：7
        解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
        示例 2：

        输入：matrix = [[5,2],[1,6]], k = 2
        输出：5
        解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
        示例 3：

        输入：matrix = [[5,2],[1,6]], k = 3
        输出：4
        解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
        示例 4：

        输入：matrix = [[5,2],[1,6]], k = 4
        输出：0
        解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。*/