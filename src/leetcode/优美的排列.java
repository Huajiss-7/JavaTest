package leetcode;

import java.util.*;

public class 优美的排列 {
    public static void main(String[] args) {
        System.out.println(countArrangement1(2));
    }


    //抄的
    public static int countArrangement1(int n) {
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1); // -1 表示没有计算过
        return dfs(0, n, memo);//从啥也没选开始
    }

    //s表示当前选过哪些数，例如s={0,2,3} 那么压缩后的s=1101
    private static int dfs(int s, int n, int[] memo) {
        if (s == (1 << n) - 1) {//全部选过了  此时s的2进制11111111111....
            return 1;
        }
        if (memo[s] != -1) { // 之前计算过
            return memo[s];
        }
        int res = 0;
        int i = Integer.bitCount(s) + 1;//Integer.bitCount(s)统计s的二进制中有几个1的数量，这个数量+1，表示当前集合大小+1，这里表示当前是要往第几个下标放数
        for (int j = 1; j <= n; j++) {
            if ((s >> (j - 1) & 1) == 0 && (i % j == 0 || j % i == 0)) {//如果当前要放的数没被用过，且符合题目条件，就放这个数然后继续递归
                res += dfs(s | (1 << (j - 1)), n, memo);//把这里s用的数变为1
            }
        }
        memo[s] = res; // 记忆化
        return res;
    }


    //自己写的
    public static int countArrangement(int n) {
        List<Integer>count = new ArrayList();
        List<Integer>[]match=new List[n+1];//match[i]表示第i个位置上，符合条件的元素链表
        boolean[] visited=new boolean[n+1];
        for (int i = 0; i < match.length; i++) {
            match[i]=new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i%j==0||j%i==0){
                    match[i].add(j);
                }
            }
        }
        dfs(1, 0,match,visited,count);
        return count.size();
    }

    public static void dfs(int index,int size,List<Integer>[]match,boolean[] visited,List<Integer>count) {
        if(size==match.length-1){//size==n
            count.add(0);//随便加，加什么不重要，count的长度才是要用的
            return;
        }

        for (int i = index; i < match.length; i++) {
            for (Integer integer : match[i]) {
                if(!visited[integer]){
                    visited[integer]=true;
                    dfs(i+1,size+1,match,visited,count);
                    visited[integer]=false;
                }
            }
        }
    }

    //暴力回溯
    List<Integer>[] match;
    boolean[] vis;
    int num;

    public int countArrangement2(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    public void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                vis[x] = false;
            }
        }
    }


}

/*
假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：

perm[i] 能够被 i 整除
i 能够被 perm[i] 整除
给你一个整数 n ，返回可以构造的 优美排列 的 数量 。



示例 1：

输入：n = 2
输出：2
解释：
第 1 个优美的排列是 [1,2]：
        - perm[1] = 1 能被 i = 1 整除
    - perm[2] = 2 能被 i = 2 整除
第 2 个优美的排列是 [2,1]:
        - perm[1] = 2 能被 i = 1 整除
    - i = 2 能被 perm[2] = 1 整除
示例 2：

输入：n = 1
输出：1*/
