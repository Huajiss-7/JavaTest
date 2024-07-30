package leetcode;

public class 交替子数组计数 {
    public static void main(String[] args) {
        int[]nums={1,0,1,0};
        System.out.println(countAlternatingSubarrays(nums));
    }

    public static long countAlternatingSubarrays(int[] nums) {
        long count=0;
        for (int len=1; len<=nums.length; len++) {
            for (int i=0; i<nums.length-len; i++) {
                int j=i+len;
                boolean flag=true;
                for (int k=i; k<j; k++) {
                    if(nums[k]==nums[k+1]) {
                        flag=false;
                        break;
                    }
                }
                if(flag) {count++;}
            }
        }
        return count+nums.length;
    }

    public static long countAlternatingSubarrays2(int[] nums) {
        long n=nums.length;
        long[] dp=new long[(int) n];
        dp[0]=1;
        long j=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]!=nums[i-1])dp[i]=dp[i-1]+i+1-j;
            else
            {
                dp[i]=dp[i-1]+1;
                j=i;
            }
        }
        return dp[(int)n-1];
    }
}


/*
给你一个
        二进制数组
nums 。

如果一个
        子数组
中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。

返回数组 nums 中交替子数组的数量。



示例 1：

输入： nums = [0,1,1,1]

输出： 5

解释：

以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。

示例 2：

输入： nums = [1,0,1,0]

输出： 10

解释：

数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。*/
