package leetcode;

import java.util.*;

public class 安排工作以达到最大收益 {
    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }


    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        List<int[]>jobs=new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new int[]{profit[i],difficulty[i]});
        }
       /*jobs.sort(new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               if(o1[0]==o2[0])return o1[1]-o2[1];//如果利润相同，按照难度从小到大
               return o2[0]-o1[0];//按照利润从大到小
           }
       });*/

       jobs.sort((a,b)->a==b?a[1]-b[1]:b[0]-a[0]);
        for (int i = 0; i < worker.length; i++) {
            for (int j = 0; j < jobs.size(); j++) {
                if (worker[i] >= jobs.get(j)[1]) {
                    maxProfit += jobs.get(j)[0];
                    break;
                }
            }
        }
        return maxProfit;
    }


    public static int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        //用map可能会有利润相同，难度不同的情况，就被覆盖了
        Map<Integer, Integer> map = new HashMap<>();//键保存利润，值保存难度
        for (int i = 0; i < difficulty.length; i++) {
            map.put(profit[i], difficulty[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());//按键排序
        list=list.reversed();//从大到小
        for (int i = 0; i < worker.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (worker[i] >= list.get(j).getValue()) {
                    maxProfit += list.get(j).getKey();
                    break;
                }
            }
        }
        return maxProfit;
    }
}

    /*你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:

        difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
        worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
        每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。

        举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
        返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。



        示例 1：

        输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
        输出: 100
        解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
        示例 2:

        输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
        输出: 0*/