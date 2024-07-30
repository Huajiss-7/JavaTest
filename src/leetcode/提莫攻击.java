package leetcode;

import java.util.Arrays;

public class 提莫攻击 {
    public static void main(String[] args) {
        int[]timeSeries={1,2};
        System.out.println(findPoisonedDuration(timeSeries, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int time=0;
        for (int i = 0; i < timeSeries.length; i++) {
            int originTime = timeSeries[i];
            int rightBound = timeSeries[i] + duration-1;
            while (i+1<timeSeries.length&&rightBound>=timeSeries[i+1]) {
                i++;
                rightBound=timeSeries[i]+duration-1;
            }
            time+=rightBound-originTime+1;
        }
        return time;
    }

    int findPoisonedDuration2(int[] timeSeries, int duration) {
        int sum = duration;
        for (int i = 0; i < timeSeries.length - 1; i++)
            sum += Math.min(timeSeries[i+1] - timeSeries[i], duration);
        return sum;
    }

    //种花问题
    //假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
    //
    //给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：flowerbed = [1,0,0,0,1], n = 1
    //输出：true
    //示例 2：
    //
    //输入：flowerbed = [1,0,0,0,1], n = 2
    //输出：false
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if(flowerbed[0]==0&&flowerbed[1]==0) {
            flowerbed[0]=1;
            count++;
        }
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i+1] == 0&&flowerbed[i-1]==0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        if(flowerbed[flowerbed.length-2]==0&&flowerbed[flowerbed.length-1]==0) {
            count++;
        }
        return count >= n;
    }

    public boolean canPlaceFlowers2(int[] oldflowerbed, int n) {
        int count = 0;
        int[]flowerbed=new int[oldflowerbed.length+2];
        for (int i = 0; i < oldflowerbed.length; i++) {
            flowerbed[i+1]=oldflowerbed[i];
        }
        flowerbed[0]=0;
        flowerbed[flowerbed.length-1]=0;
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i+1] == 0&&flowerbed[i-1]==0) {
                count++;
                flowerbed[i] = 1;
            }
        }

        return count >= n;
    }

    //分发饼干
    //假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
    //
    //对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
    //
    //
    //示例 1:
    //
    //输入: g = [1,2,3], s = [1,1]
    //输出: 1
    //解释:
    //你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
    //虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
    //所以你应该输出1。
    //示例 2:
    //
    //输入: g = [1,2], s = [1,2,3]
    //输出: 2
    //解释:
    //你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
    //你拥有的饼干数量和尺寸都足以让所有孩子满足。
    //所以你应该输出2.
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0,j=0; j<s.length&&i < g.length; i++) {
            while (j<s.length&&s[j]<g[i]) {
                j++;
            }
            if(j<s.length&&s[j]>=g[i]) {
                count++;
                j++;
            }
        }
        return count;
    }

    //岛屿的周长
    /*给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。

    网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

    岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。



    示例 1：



    输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
    输出：16
    解释：它的周长是上面图片中的 16 个黄色的边
    示例 2：

    输入：grid = [[1]]
    输出：4
    示例 3：

    输入：grid = [[1,0]]
    输出：4*/
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) {
                    if(i-1<0||grid[i-1][j]==0) perimeter++;
                    if(j+1>=grid[0].length||grid[i][j+1]==0) perimeter++;
                    if(i+1>=grid.length||grid[i+1][j]==0) perimeter++;
                    if(j-1<0||grid[i][j-1]==0) perimeter++;
                }
            }
        }
        return perimeter;
    }
}

