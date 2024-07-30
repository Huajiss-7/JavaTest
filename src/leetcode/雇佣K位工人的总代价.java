package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 雇佣K位工人的总代价 {
    public static void main(String[] args) {
        int[]costs={17,12,10,2,7,2,11,20,8};
        System.out.println(totalCost(costs, 3, 4));
    }

    //超时
    public static long totalCost(int[] costs, int k, int candidates) {
        int total=0;
        List<Integer> list = Arrays.stream(costs).boxed().collect(Collectors.toList());
        /*List<Integer> list= new ArrayList<>();
        for (int cost : costs) {
            list.add(cost);
        }*/
        for (int i = 0; i < k; i++) {
            int min=list.get(0);
            int index=0;
            if(list.size()<candidates){
                for (int m = 0; m < list.size(); m++) {
                    min=Math.min(list.get(m),min);
                    if(list.get(m)==min)index=m;
                }
                total+=min;
                list.remove(index);
                continue;
            }
            for (int j=0;j<candidates;j++){
                min=Math.min(min,list.get(j));
                min=Math.min(min,list.get(list.size()-1-j));
                if(list.get(list.size()-1-j)==min)index=list.size()-1-j;
                if(list.get(j)==min)index=j;
            }
            list.remove(index);
            total+=min;
        }
        return total;
    }

    //抄的
    /*雇佣过程可以用两个最小堆来模拟，一个负责维护 costs\textit{costs}costs 剩余数字的最前面 candidates\textit{candidates}candidates 个数的最小值，另一个负责维护 costs\textit{costs}costs 剩余数字的最后面 candidates\textit{candidates}candidates 个数的最小值。

    具体算法如下：

    设 cost\textit{cost}cost 的长度为 nnn。如果 candidates⋅2+k>n\textit{candidates}\cdot 2 + k > ncandidates⋅2+k>n，我们一定可以选到 cost\textit{cost}cost 中最小的 kkk 个数，所以直接返回 cost\textit{cost}cost 的前 kkk 小之和。
    初始化答案 ans=0\textit{ans}=0ans=0。初始化最小堆 pre\textit{pre}pre 为 costs\textit{costs}costs 最前面的 candidates\textit{candidates}candidates 个数，初始化最小堆 suf\textit{suf}suf 为 costs\textit{costs}costs 最后面的 candidates\textit{candidates}candidates 个数。初始化下标 i=candidates, j=n−1−candidatesi = \textit{candidates},\ j = n-1- \textit{candidates}i=candidates, j=n−1−candidates。
    循环至多 kkk 次，或者当 i>ji>ji>j 时退出循环。
    每次循环，如果 pre\textit{pre}pre 的堆顶小于等于 suf\textit{suf}suf 的堆顶，则弹出 pre\textit{pre}pre 的堆顶，加入答案，然后把 costs[i]\textit{costs}[i]costs[i] 加入 pre\textit{pre}pre，iii 增加 111；如果 suf\textit{suf}suf 的堆顶小于 pre\textit{pre}pre 的堆顶，则弹出 suf\textit{suf}suf 的堆顶，加入答案，然后把 costs[j]\textit{costs}[j]costs[j] 加入 suf\textit{suf}suf，jjj 减少 111。
    如果因为 i>ji>ji>j 退出循环（这意味着 pre\textit{pre}pre 和 suf\textit{suf}suf 相邻了），把剩余元素的前 kkk 小之和加入答案。
    返回答案。*/

    public static long totalCost1(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (candidates * 2 + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }

        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            pre.offer(costs[i]);
            suf.offer(costs[n - 1 - i]);
        }
        int i = candidates, j = n - 1 - candidates;
        while (k-- > 0) {
            if (pre.peek() <= suf.peek()) {
                ans += pre.poll();
                if (i <= j) {
                    pre.offer(costs[i++]);
                }
            } else {
                ans += suf.poll();
                if (i <= j) {
                    suf.offer(costs[j--]);
                }
            }
        }
        return ans;
    }

}

/*
给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。

        同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：

        总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
        在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
        比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
        第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
        如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
        一位工人只能被选择一次。
        返回雇佣恰好 k 位工人的总代价。



        示例 1：

        输入：costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
        输出：11
        解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
        - 第一轮雇佣，我们从 [17,12,10,2,7,2,11,20,8] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人。总代价是 0 + 2 = 2 。
        - 第二轮雇佣，我们从 [17,12,10,7,2,11,20,8] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
        - 第三轮雇佣，我们从 [17,12,10,7,11,20,8] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3 的工人同时在最前面和最后面 4 位工人中。
        总雇佣代价是 11 。
        示例 2：

        输入：costs = [1,2,4,1], k = 3, candidates = 3
        输出：4
        解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
        - 第一轮雇佣，我们从 [1,2,4,1] 中选择。最小代价为 1 ，有两位工人，我们选择下标更小的一位工人，即第 0 位工人，总代价是 0 + 1 = 1 。注意，下标为 1 和 2 的工人同时在最前面和最后面 3 位工人中。
        - 第二轮雇佣，我们从 [2,4,1] 中选择。最小代价为 1 ，下标为 2 ，总代价是 1 + 1 = 2 。
        - 第三轮雇佣，少于 3 位工人，我们从剩余工人 [2,4] 中选择。最小代价是 2 ，下标为 0 。总代价为 2 + 2 = 4 。
        总雇佣代价是 4 。*/
