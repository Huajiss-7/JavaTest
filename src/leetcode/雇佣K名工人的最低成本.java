package leetcode;

import java.math.BigDecimal;
import java.util.*;

//2024.5.2
//第一道leetcode困难题，第91道leetcode题
public class 雇佣K名工人的最低成本 {
    public static void main(String[] args) {
        int[]quality={10,20,5};
        int[]wage={70,50,30};
        System.out.println(mincostToHireWorkers(quality, wage, 2));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<BigDecimal>rate=new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            BigDecimal bigDecimal=new BigDecimal((double) wage[i]/quality[i]);
            rate.add(bigDecimal);
        }

        //这里有bug，也就是map一个key只能有一个value，而实际上一个可能有很多一样的quality对应有不同的wage，不是取其中最大就行的，应该分别对应，目前想到的方式就是把map换成建一个worker类去一个一个存
        Map<Integer,BigDecimal>map=new HashMap<>();
        for (int i = 0; i < rate.size(); i++) {
            map.put(quality[i],new BigDecimal(Math.max(map.getOrDefault(quality[i],new BigDecimal(0)).doubleValue(),rate.get(i).doubleValue())));
        }

        List<List<Integer>>combination=combine(quality,k);

        double minCost=Double.MAX_VALUE;
        for (int i = 0; i < combination.size(); i++) {
            double maxRate=map.get(combination.get(i).get(0)).doubleValue();
            int total=0;
            for (int j = 0; j < combination.get(i).size(); j++) {
                maxRate=Math.max(maxRate,map.get(combination.get(i).get(j)).doubleValue());
                total+=combination.get(i).get(j);
            }
            minCost=Math.min(minCost,total*maxRate);
        }

        return minCost;
    }

    public static List<List<Integer>> combine(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(nums, k, 0, combination, result);
        return result;
    }

    private static void backtrack(int[] nums, int k, int start, List<Integer> combination, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= nums.length - k; i++) {//因为组合总共要k个元素，所以到最后k个的时候，就是唯一一种组合，不用再循环，而前面的元素因为总共要取k个，所以第一个取的元素一定不在最后k个元素，而随之取第二个第三个...迟早会覆盖最后的k个元素，改成length-1效果一样
            combination.add(nums[i]);
            backtrack(nums, k - 1, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    //GPT的
    public static double mincostToHireWorkers1(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers, Comparator.comparingDouble(a -> a.ratio));

        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();
        for (Worker worker : workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > K)
                sumq += pool.poll();
            if (pool.size() == K)
                ans = Math.min(ans, worker.ratio * sumq);
        }

        return ans;
    }

    static class Worker {
        int quality, wage;
        double ratio;
        Worker(int q, int w) {
            quality = q;
            wage = w;
            ratio = (double) wage / quality;
        }
    }


}

   /* 有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 。

        现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资：

        对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
        工资组中的每名工人至少应当得到他们的最低期望工资。
        给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10-5 以内的答案将被接受。。



        示例 1：

        输入： quality = [10,20,5], wage = [70,50,30], k = 2
        输出： 105.00000
        解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
        示例 2：

        输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
        输出： 30.66667
        解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。

-----------------------------------------------------------------------
        看题目看了半天，说下自己的理解

        用示例一举例

        quality = [10,20,5], wage = [70,50,30], k = 2

        3个工人完成1质量所需要的工资分别为7，2.5, 6

        按题意需要选出2人为一组， 假设选择的是0号和1号

        根据题目要求我们需要把1号完成1质量的工资提升到7， 也就是和0号一样， 这样才能保证公平， 此时需要支付给1号的工资为 20*7 = 140， 因此该组需要的工资为 70 + 140 = 210

        如果0号和2号一组，需要的工资为(10+5) * 7 = 105,

        如果1号和2号一组，需要的工资为 (20+5) * 6 = 150

        因此选择0号和2号，需要的工资最低为105

        可以看出，k个人的工资为 k个人的质量总和 * k个人的wage/quality的最大值*/
