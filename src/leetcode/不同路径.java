package leetcode;

public class 不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        //不同路径II
        int[][]obstacleGrid={
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePaths(int m, int n) {
        int[][]nums=new int[m][n];//记录到达坐标m,n有几种方式
        for (int i = 0; i < nums.length; i++) {
            nums[i][0]=1;//到达第一列只有一种方式
        }
        for (int i = 0; i < nums[0].length; i++) {
            nums[0][i]=1;//到达第一行只有一种方式
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[i].length; j++) {
                nums[i][j]=nums[i-1][j]+nums[i][j-1];//到达第i,j位置的方式，等于到达其上面的方式+到达其左侧的方式
            }
        }
        return nums[m-1][n-1];
    }

    //新添一个障碍数组，1表示有障碍，不能走
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][]nums=new int[m][n];//记录到达坐标m,n有几种方式

        //最开始下面初始化第一行和第一列忘了break了，所以多了下面这些无用代码
        /*if(obstacleGrid[0][0]==1)return 0;

        if(nums.length==1){
            for (int i : obstacleGrid[0]) {
                if(i==1)return 0;
            }
        }

        if(nums[0].length==1){
            for (int[] ints : obstacleGrid) {
                if(ints[0]==1)return 0;
            }
        }*/

        for (int i = 0; i < nums.length; i++) {
            if(obstacleGrid[i][0]==1){nums[i][0]=0;break;}
            else nums[i][0]=1;//到达第一列只有一种方式
        }
        for (int i = 0; i < nums[0].length; i++) {
            if(obstacleGrid[0][i]==1){nums[0][i]=0;break;}
            else nums[0][i]=1;//到达第一行只有一种方式
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[i].length; j++) {
                if(obstacleGrid[i][j]==1)nums[i][j]=0;
                else nums[i][j]=nums[i-1][j]+nums[i][j-1];//到达第i,j位置的方式，等于到达其上面的方式+到达其左侧的方式
            }
        }
        return nums[m-1][n-1];
    }
}

    /*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

        问总共有多少条不同的路径？



        示例 1：


        输入：m = 3, n = 7
        输出：28
        示例 2：

        输入：m = 3, n = 2
        输出：3
        解释：
        从左上角开始，总共有 3 条路径可以到达右下角。
        1. 向右 -> 向下 -> 向下
        2. 向下 -> 向下 -> 向右
        3. 向下 -> 向右 -> 向下
        示例 3：

        输入：m = 7, n = 3
        输出：28
        示例 4：

        输入：m = 3, n = 3
        输出：6*/