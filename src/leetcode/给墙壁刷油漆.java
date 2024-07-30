package leetcode;

import java.util.Arrays;

//困难
public class 给墙壁刷油漆 {
    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 2};
        int[] time = {1, 2, 3, 2};
        System.out.println(paintWalls(cost, time));
    }

    public static int paintWalls(int[] cost, int[] time) {
        int[][] memo = new int[cost.length][cost.length * 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(cost.length - 1, 0, cost, time,memo);
    }

    //前面的时间可以先欠着，直到后面还
    //dfs(index,timeLeft) 刷完0-index面墙，当前付费剩余时间为timeLeft的最小开销
    public static int dfs(int indexOfWall, int timeLeft, int[] cost, int[] time,int[][] memo) {
        if (timeLeft >= indexOfWall + 1) return 0;//剩下的墙都可以免费刷了

        if (indexOfWall < 0) {
            return Integer.MAX_VALUE/2;//当无墙可刷，欠的时间无法弥补时(没有触发上面的if)，返回最大值，表示不可行，/2防止加法溢出
        } /*else if (timeLeft < 0) {
            return dfs(indexOfWall - 1, timeLeft + time[indexOfWall], cost, time) + cost[indexOfWall];
        }*/
        int k = timeLeft + memo.length; // 加上偏移量，防止出现负数
        if (memo[indexOfWall][k] != -1) { // 之前计算过
            return memo[indexOfWall][k];
        }

        return memo[indexOfWall][k]=Math.min(dfs(indexOfWall - 1, timeLeft - 1, cost, time,memo)//第i堵墙免费刷，等于前i-1堵的花费
                , dfs(indexOfWall - 1, timeLeft + time[indexOfWall], cost, time,memo) + cost[indexOfWall]);//付费刷
    }
}

/*
给你两个长度为 n 下标从 0 开始的整数数组 cost 和 time ，分别表示给 n 堵不同的墙刷油漆需要的开销和时间。你有两名油漆匠：

一位需要 付费 的油漆匠，刷第 i 堵墙需要花费 time[i] 单位的时间，开销为 cost[i] 单位的钱。
一位 免费 的油漆匠，刷 任意 一堵墙的时间为 1 单位，开销为 0 。但是必须在付费油漆匠 工作 时，免费油漆匠才会工作。
请你返回刷完 n 堵墙最少开销为多少。



示例 1：

输入：cost = [1,2,3,2], time = [1,2,3,2]
输出：3
解释：下标为 0 和 1 的墙由付费油漆匠来刷，需要 3 单位时间。同时，免费油漆匠刷下标为 2 和 3 的墙，需要 2 单位时间，开销为 0 。总开销为 1 + 2 = 3 。
示例 2：

输入：cost = [2,3,4,2], time = [1,1,1,1]
输出：4
解释：下标为 0 和 3 的墙由付费油漆匠来刷，需要 2 单位时间。同时，免费油漆匠刷下标为 1 和 2 的墙，需要 2 单位时间，开销为 0 。总开销为 2 + 2 = 4 。*/
