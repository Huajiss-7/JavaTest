package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 特别的排列 {
    public static void main(String[] args) {
        int[]nums={2,3,6};
        System.out.println(specialPerm(nums));
    }


    //抄的
    public static int specialPerm1(int[] nums) {
        int n = nums.length;
        int u = (1 << n) - 1;//全集
        long[][] memo = new long[u][n];//对应的每种状态记忆化，存储的是每种选择情况，以及当前这次选择的位置的下标
        for (long[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(u ^ (1 << i), i, nums, memo);//从0开始每一位选一遍，并把其对应的下标也传入
        }
        return (int) (ans % 1_000_000_007);
    }

    private static long dfs(int s, int i, int[] nums, long[][] memo) {
        if (s == 0) {
            return 1; // 找到一个特别排列
        }
        if (memo[s][i] != -1) { // 之前计算过
            return memo[s][i];
        }
        long res = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((s >> j & 1) > 0 && (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)) {
                res += dfs(s ^ (1 << j), j, nums, memo);
            }
        }
        return memo[s][i] = res; // 记忆化
    }

    //链接：https://leetcode.cn/problems/special-permutations/solutions/2312798/zhuang-ya-dp-by-endlesscheng-4jkr/



    //错了
    public static int specialPerm(int[] nums) {
        int n = nums.length;
        //int[]s=new int[1<<n];//用于保留所有状态
        int[]memo=new int[1<<n];//保留所有状态是否被访问过
        Arrays.fill(memo,-1);
        Map<Integer,Integer> map=new HashMap<>();//用二进制1位置对应的值，存nums[]对应位置的值，例如nums={6,2}则10=2:2  01=1:6
        for (int i = 0; i < nums.length; i++) {
            map.put(1<<i,nums[i]);
        }
        return dfs(0,memo,map);
    }

    private static int dfs(int s, int[] memo, Map<Integer,Integer> map){
        if(s==(1<<map.size()-1)){//完成一次排列 s全被选过了，11111111...
            return 1;
        }
        if(memo[s]!=-1) return memo[s];//记录过这种情况
        int ans=0;

        for (int j=1;j<map.size();j++){
            if((s>>(j-1)&1)==0&&(map.get(1<<(j-1))%map.get(1<<j)==0||map.get(1<<j)%map.get(1<<(j-1))==0)){
                ans+=dfs(s|1<<(j-1),memo,map);
            }
        }
        memo[s]=ans;
        return ans;
    }
}

/*
给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：

对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] == 0 。
请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。



示例 1：

输入：nums = [2,3,6]
输出：2
解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
示例 2：

输入：nums = [1,4,3]
输出：2
解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。*/
