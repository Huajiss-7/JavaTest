package leetcode;

public class 目标和 {
    public static void main(String[] args) {
        int[]nums={1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,target,0,0,0)+dfs(nums,target,1,0,0);
    }

    private static int dfs(int[]nums, int target,int operate,int i ,int currentSum) {
        if(operate==1) {
            currentSum+=nums[i];
        }else {
            currentSum-=nums[i];
        }
        if(i==nums.length-1){
            if(currentSum==target)return 1;
            else return 0;
        }
        int ans=0;
        if(operate==1){
            ans+=dfs(nums,target,1,i+1,currentSum);
            ans+=dfs(nums,target,0,i+1,currentSum);
        }
        if(operate==0){
            ans+=dfs(nums,target,0,i+1,currentSum);
            ans+=dfs(nums,target,1,i+1,currentSum);
        }
        return ans;
    }
}

/*
给你一个非负整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。



示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
        -1 + 1 + 1 + 1 + 1 = 3
        +1 - 1 + 1 + 1 + 1 = 3
        +1 + 1 - 1 + 1 + 1 = 3
        +1 + 1 + 1 - 1 + 1 = 3
        +1 + 1 + 1 + 1 - 1 = 3
示例 2：

输入：nums = [1], target = 1
输出：1*/
