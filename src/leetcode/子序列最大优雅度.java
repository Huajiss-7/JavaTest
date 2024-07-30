package leetcode;

import java.util.*;

public class 子序列最大优雅度 {
    public static void main(String[] args) {
        //int[][] arr = {{3,2}, {5,1}, {10,1}};
        int[][]arr={{3,1},{3,1},{2,2},{5,3}};
        System.out.println(findMaximumElegance2(arr, 3));
    }

    //GPT改进
    public static long findMaximumElegance1(int[][] items, int k) {
        // Step 1: Sort items by profit in descending order
        Arrays.sort(items, (o1, o2) -> o2[0] - o1[0]);

        long currentProfit = 0;
        Map<Integer, ArrayList<Integer>> categoryToProfits = new HashMap<>();
        Set<Integer> distinctCategories = new HashSet<>();

        // Step 2: Select the first k items
        for (int i = 0; i < k; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            currentProfit += profit;
            categoryToProfits.computeIfAbsent(category, x -> new ArrayList<>()).add(profit);
            distinctCategories.add(category);
        }

        long maxElegance = currentProfit + (long) distinctCategories.size() * distinctCategories.size();

        // Step 3: Try to improve elegance by replacing items
        for (int i = k; i < items.length; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            if (distinctCategories.contains(category)) continue;

            int[] minRedundantInfo = getMinRedundantProfit(categoryToProfits);
            if (minRedundantInfo[0] == -1) break;

            int redundantCategory = minRedundantInfo[0];
            int minRedundantProfit = minRedundantInfo[1];

            // Replace the redundant item
            categoryToProfits.get(redundantCategory).remove((Integer) minRedundantProfit);
            if (categoryToProfits.get(redundantCategory).isEmpty()) {
                categoryToProfits.remove(redundantCategory);
                distinctCategories.remove(redundantCategory);
            }

            categoryToProfits.computeIfAbsent(category, x -> new ArrayList<>()).add(profit);
            distinctCategories.add(category);

            currentProfit = currentProfit - minRedundantProfit + profit;
            maxElegance = Math.max(maxElegance, currentProfit + (long) distinctCategories.size() * distinctCategories.size());
        }

        return maxElegance;
    }

    private static int[] getMinRedundantProfit(Map<Integer, ArrayList<Integer>> categoryToProfits) {
        int minProfit = Integer.MAX_VALUE;
        int minCategory = -1;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : categoryToProfits.entrySet()) {
            if (entry.getValue().size() < 2) continue;

            for (Integer profit : entry.getValue()) {
                if (profit < minProfit) {
                    minProfit = profit;
                    minCategory = entry.getKey();
                }
            }
        }

        return new int[]{minCategory, minProfit};
    }

    //有bug
    //找到了，应该是temp=(int)(max-(kinds.size()-1)-info[1]+items[i][0]);
    //而不是temp=(int)(max-info[1]+items[i][0]);
    //还有bug
    //找到了，应该是temp=(int)(max-((kinds.size()-1)*(kinds.size()-1))-info[1]+items[i][0]);
    //而不是temp=(int)(max-(kinds.size()-1)-info[1]+items[i][0]);
    public static long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (o1, o2) -> o2[0]-o1[0]);//利润降序排列
        long max=0;
        //Set kinds=new HashSet<>();
        Map<Integer,ArrayList<Integer>>kinds=new HashMap<>();//记录同一个1种类所有项的，数目和利润
        //值list的size就是数目，键是种类，list里的值就是大小
        for (int i = 0; i < k; i++) {
            max+=items[i][0];
            if(kinds.containsKey(items[i][1])){//以种类为键
                kinds.get(items[i][1]).add(items[i][0]);
            }else {
                ArrayList<Integer> list=new ArrayList<>();
                list.add(items[i][0]);
                kinds.put(items[i][1],list);
            }
        }
        max+=kinds.size()*kinds.size();
        for(int i=k;i<items.length;i++){
            if(kinds.containsKey(items[i][1]))continue;
            else {
                int[]info=getMinProfitOfRedundance(kinds);//获得map中最小冗余利润值的利润大小和种类key,返回二元组第一个是种类，第二个是利润大小
                if(info[0]==-1)break;//没找到
                kinds.get(info[0]).remove((Integer) info[1]);
                ArrayList list=new ArrayList<>();
                list.add(items[i][0]);
                kinds.put(items[i][1],list);
                Integer temp=(int)(max-((kinds.size()-1)*(kinds.size()-1))-info[1]+items[i][0]);
                max=Math.max(max,temp+kinds.size()*kinds.size());
            }
        }
        return max;
    }

    private static int[]getMinProfitOfRedundance(Map<Integer,ArrayList<Integer>>map){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size()<2)continue;
            for (Integer i : entry.getValue()) {
                if(min>i){
                    min=i;
                    index=entry.getKey();
                }
            }
        }
        return new int[]{index,min};
    }

    //改好了
    public static long findMaximumElegance2(int[][] items, int k) {
        Arrays.sort(items, (o1, o2) -> o2[0]-o1[0]);//利润降序排列
        long max=0;
        long curProfit=0;
        //Set kinds=new HashSet<>();
        Map<Integer,ArrayList<Integer>>kinds=new HashMap<>();//记录同一个1种类所有项的，数目和利润
        //值list的size就是数目，键是种类，list里的值就是大小
        for (int i = 0; i < k; i++) {
            curProfit+=items[i][0];
            if(kinds.containsKey(items[i][1])){//以种类为键
                kinds.get(items[i][1]).add(items[i][0]);
            }else {
                ArrayList<Integer> list=new ArrayList<>();
                list.add(items[i][0]);
                kinds.put(items[i][1],list);
            }
        }
        max= curProfit+(long)kinds.size()*kinds.size();
        for(int i=k;i<items.length;i++){
            if(kinds.containsKey(items[i][1]))continue;
            else {
                int profit=items[i][0];
                int[]info=getMinProfitOfRedundance(kinds);//获得map中最小冗余利润值的利润大小和种类key,返回二元组第一个是种类，第二个是利润大小
                if(info[0]==-1)break;//没找到
                kinds.get(info[0]).remove((Integer) info[1]);
                ArrayList list=new ArrayList<>();
                list.add(items[i][0]);
                kinds.put(items[i][1],list);
                curProfit=(curProfit-info[1]+items[i][0]);
                max=Math.max(max,curProfit+(long) kinds.size()*kinds.size());
            }
        }
        return max;
    }


    //更好的做法
    public static long findMaximumElegance3(int[][] items, int k) {
        // 把利润从大到小排序
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        long ans = 0;
        long totalProfit = 0;
        Set<Integer> vis = new HashSet<>();
        Deque<Integer> duplicate = new ArrayDeque<>(); // 重复类别的利润
        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            if (i < k) {
                totalProfit += profit; // 累加前 k 个项目的利润
                if (!vis.add(category)) { // 重复类别
                    duplicate.push(profit);
                }
            } else if (!duplicate.isEmpty() && vis.add(category)) { // 之前没有的类别
                totalProfit += profit - duplicate.pop(); // 选一个重复类别中的最小利润替换
            } // else：比前面的利润小，而且类别还重复了，选它只会让 totalProfit 变小，vis.size() 不变，优雅度不会变大
            ans = Math.max(ans, totalProfit + (long) vis.size() * vis.size()); // 注意 1e5*1e5 会溢出
        }
        return ans;
    }

}


/*
给你一个长度为 n 的二维整数数组 items 和一个整数 k 。

items[i] = [profiti, categoryi]，其中 profiti 和 categoryi 分别表示第 i 个项目的利润和类别。

现定义 items 的 子序列 的 优雅度 可以用 total_profit + distinct_categories2 计算，其中 total_profit 是子序列中所有项目的利润总和，distinct_categories 是所选子序列所含的所有类别中不同类别的数量。

你的任务是从 items 所有长度为 k 的子序列中，找出 最大优雅度 。

用整数形式表示并返回 items 中所有长度恰好为 k 的子序列的最大优雅度。

注意：数组的子序列是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。



示例 1：

输入：items = [[3,2],[5,1],[10,1]], k = 2
输出：17
解释：
在这个例子中，我们需要选出长度为 2 的子序列。
其中一种方案是 items[0] = [3,2] 和 items[2] = [10,1] 。
子序列的总利润为 3 + 10 = 13 ，子序列包含 2 种不同类别 [2,1] 。
因此，优雅度为 13 + 2*2 = 17 ，可以证明 17 是可以获得的最大优雅度。
示例 2：

输入：items = [[3,1],[3,1],[2,2],[5,3]], k = 3
输出：19
解释：
在这个例子中，我们需要选出长度为 3 的子序列。
其中一种方案是 items[0] = [3,1] ，items[2] = [2,2] 和 items[3] = [5,3] 。
子序列的总利润为 3 + 2 + 5 = 10 ，子序列包含 3 种不同类别 [1, 2, 3] 。
因此，优雅度为 10 + 32 = 19 ，可以证明 19 是可以获得的最大优雅度。
示例 3：

输入：items = [[1,1],[2,1],[3,1]], k = 3
输出：7
解释：
在这个例子中，我们需要选出长度为 3 的子序列。
我们需要选中所有项目。
子序列的总利润为 1 + 2 + 3 = 6，子序列包含 1 种不同类别 [1] 。
因此，最大优雅度为 6 + 12 = 7 。*/
