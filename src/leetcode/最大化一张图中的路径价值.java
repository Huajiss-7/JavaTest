package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大化一张图中的路径价值 {
    public static void main(String[] args) {
        int[]values={0,32,10,43};
        int[][]edges={{0,1,10},{1,2,15},{0,3,10}};
        System.out.println(maximalPathQuality(values, edges, 49));
    }

    //暴力递归
    public static int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<int[]>[] graph=new List[values.length];
        Arrays.setAll(graph,i->new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            int time=edges[i][2];
            graph[x].add(new int[]{y,time});
            graph[y].add(new int[]{x,time});
        }
        boolean[] visited=new boolean[values.length];
        visited[0]=true;
        //return dfs(0,0,0,graph,visited,maxTime/2,values);
        return dfs1(0,0,values[0],graph,visited,maxTime,values);
    }


    //抄的
    private static int dfs1(int curNode,int nowTime,int nowValue,List<int[]>[] graph, boolean[] visited, int maxTime,int[] values) {
        /*起点的特殊处理：在这个问题中，路径的起点和终点都是节点0。在回到起点时，我们需要记录路径的当前价值（nowValue），因为这代表了一条完整的从起点出发并回到起点的路径的价值。因此，当当前节点（curNode）是0时，我们将 res 设置为当前的路径价值 nowValue。

        其他节点的处理：对于非起点的节点，如果它不是起点（即 curNode != 0），我们将 res 初始化为0。因为在这些节点上，只有当我们返回到起点时，才会计算路径的最终价值。在这些节点上，我们主要是继续探索其他可能的路径。

        DFS中的路径探索：在DFS的递归过程中，我们会检查所有可能的路径。如果路径经过的时间不超过 maxTime，我们会继续沿着该路径探索下去。如果我们访问过该节点（visited[y]），我们会继续DFS，但不增加 nowValue，因为我们已经访问过该节点的价值。如果我们没有访问过该节点，我们会增加该节点的价值并继续DFS。*/
        int res=curNode==0?nowValue:0;
        for (int[] e : graph[curNode]) {
            int y=e[0];
            int time=e[1];
            //不停走，直到走到超时为止，路过0点时刷新res的值，再往后的值如果超时前没回去就不算
            if(nowTime+time>maxTime)continue;//结果超了，不返回，继续换路走，不能>=因为如果恰好等于了，还能走，如果这一步正好走回起点就会影响结果
            if(visited[y])res=Math.max(res,dfs1(y,nowTime+time,nowValue,graph,visited,maxTime,values));//回退，访问过了，不计算节点的value，但还计算时间，所以不用担心有环路导致无穷循环
            else {
                visited[y]=true;
                res=Math.max(res,dfs1(y,nowTime+time,nowValue+values[y],graph,visited,maxTime,values));
                visited[y]=false;
            }
        }
        return res;
    }

    //这只能深度优先
    private static int dfs(int curNode,int nowTime,int nowValue,List<int[]>[] graph, boolean[] visited, int maxTime,int[] values) {
        if(nowTime>=maxTime)return nowValue;
        int maxValue=0;
        for (int[] adjacency : graph[curNode]) {
            if(!visited[adjacency[0]]){
                visited[adjacency[0]]=true;
                maxValue=Math.max(maxValue,dfs(adjacency[0],nowTime+adjacency[1],nowValue+values[curNode],graph,visited,maxTime,values));
                visited[adjacency[0]]=false;
            }
        }
        return maxValue;
    }

}

/*给你一张 无向 图，图中有 n 个节点，节点编号从 0 到 n - 1 （都包括）。同时给你一个下标从 0 开始的整数数组 values ，其中 values[i] 是第 i 个节点的 价值 。同时给你一个下标从 0 开始的二维整数数组 edges ，其中 edges[j] = [uj, vj, timej] 表示节点 uj 和 vj 之间有一条需要 timej 秒才能通过的无向边。最后，给你一个整数 maxTime 。

合法路径 指的是图中任意一条从节点 0 开始，最终回到节点 0 ，且花费的总时间 不超过 maxTime 秒的一条路径。你可以访问一个节点任意次。一条合法路径的 价值 定义为路径中 不同节点 的价值 之和 （每个节点的价值 至多 算入价值总和中一次）。

请你返回一条合法路径的 最大 价值。

注意：每个节点 至多 有 四条 边与之相连。



示例 1：



输入：values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49
输出：75
解释：
一条可能的路径为：0 -> 1 -> 0 -> 3 -> 0 。总花费时间为 10 + 10 + 10 + 10 = 40 <= 49 。
访问过的节点为 0 ，1 和 3 ，最大路径价值为 0 + 32 + 43 = 75 。
示例 2：



输入：values = [5,10,15,20], edges = [[0,1,10],[1,2,10],[0,3,10]], maxTime = 30
输出：25
解释：
一条可能的路径为：0 -> 3 -> 0 。总花费时间为 10 + 10 = 20 <= 30 。
访问过的节点为 0 和 3 ，最大路径价值为 5 + 20 = 25 。
示例 3：



输入：values = [1,2,3,4], edges = [[0,1,10],[1,2,11],[2,3,12],[1,3,13]], maxTime = 50
输出：7
解释：
一条可能的路径为：0 -> 1 -> 3 -> 1 -> 0 。总花费时间为 10 + 13 + 13 + 10 = 46 <= 50 。
访问过的节点为 0 ，1 和 3 ，最大路径价值为 1 + 2 + 4 = 7 。
示例 4：



输入：values = [0,1,2], edges = [[1,2,10]], maxTime = 10
输出：0
解释：
唯一一条路径为 0 。总花费时间为 0 。
唯一访问过的节点为 0 ，最大路径价值为 0 。*/
