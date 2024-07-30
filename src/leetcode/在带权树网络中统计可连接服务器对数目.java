package leetcode;

import java.util.*;

public class 在带权树网络中统计可连接服务器对数目 {
    public static void main(String[] args) {
        int[][]edges={{0,1,1},{1,2,5},{2,3,13},{3,4,9},{4,5,2}};
        for (int i : countPairsOfConnectableServers1(edges, 1)) {
            System.out.print(i+" ");
        }
    }


    //搞不懂，找不出bug了
    //找到一个bug，每条路径没有加和起来
    public static int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        Map<Integer, ArrayList<Integer[]>>map=new HashMap<>();//存储每个节点和其能到达的边，key为节点，value为邻接边和其权重的集合
        for (int i = 0; i < edges.length; i++) {
            if(map.containsKey(edges[i][0])){
                Integer[]nums={edges[i][1],edges[i][2]};
                map.get(edges[i][0]).add(nums);
            }else {
                Integer[]nums={edges[i][1],edges[i][2]};
                ArrayList<Integer[]>list=new ArrayList<>();
                list.add(nums);
                map.put(edges[i][0],list);
            }
        }

        /*for (Map.Entry<Integer, ArrayList<Integer[]>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue().get(0)[0]+" "+entry.getValue().get(0)[1]);
        }*/

        int[]counts=new int[map.size()];//记录答案
        for (int i = 0; i < map.size(); i++) {//对每个节点深度优先
            int countLeft=0;//比当前节点小的符合条件的节点的数目
            int countRight=0;//比当前节点大的符合条件的节点的数目
            boolean[]used=new boolean[map.size()];//用过为true
            used[i]=true;
            Stack<ArrayList>stack=new Stack<>();
            stack.push(map.get(edges[i][0]));//取出这个节点的邻接边的集合
            int road=0;
            while (!stack.isEmpty()){
                ArrayList<Integer[]>list=stack.pop();
                if(list==null)continue;
                int len=list.size();
                road+=list.get(i)[1];
                for (int j = 0; j < len; j++) {//把所有邻接边对应连接的其它边的集合入栈
                    if(!used[list.get(j)[0]])stack.push(map.get(list.get(j)[0]));
                    used[list.get(j)[0]]=true;
                    if(road%signalSpeed==0){
                        if(list.get(j)[0]>i)countRight++;//找到比当前节点小的符合条件的节点的数目
                        else if(list.get(j)[0]<i)countLeft++;
                    }
                }
            }
            counts[i]=countRight*countLeft;
        }

        return counts;
    }

    //抄的
    public static int[] countPairsOfConnectableServers1(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int wt = e[2];
            g[x].add(new int[]{y, wt});
            g[y].add(new int[]{x, wt});
        }//g存储着每个节点和其对应的边和权重

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {//遍历每个节点，对每个节点计数
            int sum = 0;
            for (int[] e : g[i]) {//遍历当前节点的每条路径，找每条路径走到头有几个符合条件，然后排列组合
                int cnt = dfs(e[0], i, e[1], g, signalSpeed);
                ans[i] += cnt * sum;
                sum += cnt;
            }
        }
        return ans;
    }

    //x:当前节点，fa:上一个节点，sum路径之和，g整个图
    private static int dfs(int x, int fa, int sum, List<int[]>[] g, int signalSpeed) {
        int cnt = sum % signalSpeed == 0 ? 1 : 0;
        for (int[] e : g[x]) {//遍历当前节点对应的所有路径
            int y = e[0];
            if (y != fa) {//因为每个相连节点也都是成对出现的，而只要避免相邻两点之间重复就行了，因为这是个树
                cnt += dfs(y, x, sum + e[1], g, signalSpeed);
            }
        }
        return cnt;
    }

}


/*给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。再给你一个整数 signalSpeed 。

        如果两个服务器 a ，b 和 c 满足以下条件，那么我们称服务器 a 和 b 是通过服务器 c 可连接的 ：

        a < b ，a != c 且 b != c 。
        从 c 到 a 的距离是可以被 signalSpeed 整除的。
        从 c 到 b 的距离是可以被 signalSpeed 整除的。
        从 c 到 b 的路径与从 c 到 a 的路径没有任何公共边。
        请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。



        示例 1：



        输入：edges = [[0,1,1],[1,2,5],[2,3,13],[3,4,9],[4,5,2]], signalSpeed = 1
        输出：[0,4,6,6,4,0]
        解释：由于 signalSpeed 等于 1 ，count[c] 等于所有从 c 开始且没有公共边的路径对数目。
        在输入图中，count[c] 等于服务器 c 左边服务器数目乘以右边服务器数目。
        输入：edges = [[0,6,3],[6,5,3],[0,3,1],[3,2,7],[3,1,6],[3,4,2]], signalSpeed = 3
        输出：[2,0,0,0,0,0,2]
        解释：通过服务器 0 ，有 2 个可连接服务器对(4, 5) 和 (4, 6) 。
        通过服务器 6 ，有 2 个可连接服务器对 (4, 5) 和 (0, 5) 。
        所有服务器对都必须通过服务器 0 或 6 才可连接，所以其他服务器对应的可连接服务器对数目都为 0 。*/
