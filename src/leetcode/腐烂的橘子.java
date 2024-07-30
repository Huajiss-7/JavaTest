package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 腐烂的橘子 {
    public static void main(String[] args) {
        int[][]grid={{2,1,1},
                     {1,1,0},
                     {0,1,1}};
        System.out.println(orangesRotting2(grid));
    }

    //广度优先
    /*有了计算最短路径的层序 BFS 代码框架，写这道题就很简单了。这道题的主要思路是：

    一开始，我们找出所有腐烂的橘子，将它们放入队列，作为第 0 层的结点。
    然后进行 BFS 遍历，每个结点的相邻结点可能是上、下、左、右四个方向的结点，注意判断结点位于网格边界的特殊情况。
    由于可能存在无法被污染的橘子，我们需要记录新鲜橘子的数量。在 BFS 中，每遍历到一个橘子（污染了一个橘子），就将新鲜橘子的数量减一。如果 BFS 结束后这个数量仍未减为零，说明存在无法被污染的橘子。*/

    public static int orangesRotting1(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数，或者分钟数
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < M && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < N && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }


    //自己写一遍
    public static int orangesRotting2(int[][] grid) {
        Queue<int[]>queue=new LinkedList<>();
        int minutes=0;
        int count=0;//记录新鲜橘子数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==2)queue.add(new int[]{i,j});
                if(grid[i][j]==1)count++;
            }
        }

        while (count>0&&!queue.isEmpty()){
            minutes++;
            int len=queue.size();
            for (int k = 0; k < len; k++) {
                int[]arr=queue.poll();
                int i=arr[0];
                int j=arr[1];
                if(i-1>=0&&grid[i-1][j]==1){
                    grid[i-1][j]=2;
                    queue.add(new int[]{i-1,j});
                    count--;
                }
                if(i+1<grid.length&&grid[i+1][j]==1){
                    grid[i+1][j]=2;
                    queue.add(new int[]{i+1,j});
                    count--;
                }
                if(j-1>=0&&grid[i][j-1]==1){
                    grid[i][j-1]=2;
                    queue.add(new int[]{i,j-1});
                    count--;
                }
                if(j+1<grid[0].length&&grid[i][j+1]==1){
                    grid[i][j+1]=2;
                    queue.add(new int[]{i,j+1});
                    count--;
                }
            }
        }
        if(count>0)return -1;
        else return minutes;
    }


    //超时
    public static int orangesRotting(int[][] grid) {
        int minutes=0;
        int[][]record=deepCopy(grid);
        while (true) {
            boolean flag=false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j]==2){
                        if(i-1>=0&&grid[i-1][j]==1)record[i-1][j]=2;
                        if(i+1<grid.length&&grid[i+1][j]==1)record[i+1][j]=2;
                        if(j-1>=0&&grid[i][j-1]==1)record[i][j-1]=2;
                        if(j+1<grid[i].length&&grid[i][j+1]==1)record[i][j+1]=2;
                    }
                    if(grid[i][j]==1){
                        flag=true;
                    }
                }
            }
            if(!flag)break;
            grid=deepCopy(record);
            minutes++;
        }
        return minutes;
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
}

    /*在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

        值 0 代表空单元格；
        值 1 代表新鲜橘子；
        值 2 代表腐烂的橘子。
        每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

        返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。



        示例 1：



        输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
        输出：4
        示例 2：

        输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
        输出：-1
        解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
        示例 3：

        输入：grid = [[0,2]]
        输出：0
        解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。*/