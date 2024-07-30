package leetcode;

import java.util.*;

//困难
public class 求出所有子序列的能量和 {
    public static void main(String[] args) {
        int[]nums={1,2,3,4};
        System.out.println(sumOfPowers(nums, 3));
    }


    //抄的
    static final int MOD = 1000000007, INF = 0x3f3f3f3f;

    public int sumOfPowers2(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer>[][] d = new Map[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                d[i][j] = new HashMap<Integer, Integer>();
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            d[i][1].put(INF, 1);
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                for (int p = 2; p <= k; p++) {
                    for (Map.Entry<Integer, Integer> entry : d[j][p - 1].entrySet()) {
                        int v = entry.getKey(), cnt = entry.getValue();
                        int currKey = Math.min(diff, v);
                        d[i][p].put(currKey, (d[i][p].getOrDefault(currKey, 0) + cnt) % MOD);
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : d[i][k].entrySet()) {
                int v = entry.getKey(), cnt = entry.getValue();
                res = (int) ((res + 1L * v * cnt % MOD) % MOD);
            }
        }
        return res;
    }

    /*作者：力扣官方题解
    链接：https://leetcode.cn/problems/find-the-sum-of-subsequence-powers/solutions/2852864/qiu-chu-suo-you-zi-xu-lie-de-neng-liang-y4rjd/
    */

    //超时
    public static int sumOfPowers(int[] nums, int k) {
        int sum=0;
        Arrays.sort(nums);
        List<Integer> energy=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list=new ArrayList<>();
            dfs(i,nums,list,k,energy);
        }
        for (Integer integer : energy) {
            sum+=integer;
        }
        return sum;
    }

    private static void dfs(int index,int[] nums,List<Integer> list,int k,List<Integer> energy) {
        list.add(nums[index]);
        if(list.size()==k){
            int val=getEnergy(list);
            energy.add(val);
            return;
        }
        for(int i=index+1;i<nums.length;i++){
            dfs(i,nums,list,k,energy);
            list.remove(list.size()-1);
        }
    }

    private static int getEnergy(List<Integer> list) {
        int energy=Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            energy=Math.min(list.get(i)-list.get(i-1),energy);
        }
        return energy;
    }

    //完成了第一步，找出所有子序列
    /*public static int sumOfPowers(int[] nums, int k) {
        int sum=0;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list=new ArrayList<>();
            dfs(i,nums,ans,list,k);
        }
        ans.forEach(System.out::println);
        return sum;
    }

    private static void dfs(int index,int[] nums,List<List<Integer>> ans,List<Integer> list,int k) {
        list.add(nums[index]);
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index+1;i<nums.length;i++){
            dfs(i,nums,ans,list,k);
            list.remove(list.size()-1);
        }
    }*/
}

/*
给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。

一个
        子序列
的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。

请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。

由于答案可能会很大，将答案对 109 + 7 取余 后返回。



示例 1：

输入：nums = [1,2,3,4], k = 3

输出：4

解释：

nums 中总共有 4 个长度为 3 的子序列：[1,2,3] ，[1,3,4] ，[1,2,4] 和 [2,3,4] 。能量和为 |2 - 3| + |3 - 4| + |2 - 1| + |3 - 4| = 4 。

示例 2：

输入：nums = [2,2], k = 2

输出：0

解释：

nums 中唯一一个长度为 2 的子序列是 [2,2] 。能量和为 |2 - 2| = 0 。

示例 3：

输入：nums = [4,3,-1], k = 2

输出：10

解释：

nums 总共有 3 个长度为 2 的子序列：[4,3] ，[4,-1] 和 [3,-1] 。能量和为 |4 - 3| + |4 - (-1)| + |3 - (-1)| = 10 。
*/


class Solution {
    private Map<Long, Integer> f = new HashMap<>();
    private final int mod = (int) 1e9 + 7;
    private int[] nums;

    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        return dfs(0, nums.length, k, Integer.MAX_VALUE);
    }

    private int dfs(int i, int j, int k, int mi) {
        if (i >= nums.length) {
            return k == 0 ? mi : 0;
        }
        if (nums.length - i < k) {
            return 0;
        }
        long key = (1L * mi) << 18 | (i << 12) | (j << 6) | k;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        int ans = dfs(i + 1, j, k, mi);
        if (j == nums.length) {
            ans += dfs(i + 1, i, k - 1, mi);
        } else {
            ans += dfs(i + 1, i, k - 1, Math.min(mi, nums[i] - nums[j]));
        }
        ans %= mod;
        f.put(key, ans);
        return ans;
    }
}

/*作者：ylb
链接：https://leetcode.cn/problems/find-the-sum-of-subsequence-powers/solutions/2853915/python3javago-yi-ti-yi-jie-ji-yi-hua-sou-tcob/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
