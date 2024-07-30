package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},//上界
                          {4, 5, 6},
                          {7, 8, 9}};//下界
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int up = 0,low=matrix.length-1,left=0,right=matrix[0].length-1;//确定矩阵上下左右四个界限
        while (up<=low&&left<=right){//下界跑到上界上面，或者左界跑到右界右边标志遍历完成
            for (int i=left;i<=right;i++){//遍历当前的上界所在行，从左界到右界
                list.add(matrix[up][i]);
            }
            up++;//上界向下移动
            for (int i=up;i<=low;i++){//此时上界已经移动了
                list.add(matrix[i][right]);
            }
            right--;//右界向左移动
            if(up<=low){
                for (int i=right;i>=left;i--){//遍历下界从右往左
                    list.add(matrix[low][i]);
                }
                low--;//下界向上移动
            }
            if(left<=right){
                for (int i=low;i>=up;i--){//遍历下界从右往左
                    list.add(matrix[i][left]);
                }
                left++;//左界向右移动
            }
        }
        return list;
    }
}

   /* 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。



        示例 1：


        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
        示例 2：


        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        输出：[1,2,3,4,8,12,11,10,9,5,6,7]*/
