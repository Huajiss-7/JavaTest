package leetcode;

public class 访问数组中的位置使分数最大 {
    public static void main(String[] args) {
        int[]nums={2,3,6,1,9,2};
        System.out.println(maxScore1(nums, 5));
    }


    //抄的
    /*思路

    我们从左往右遍历数组，遍历到一个元素时，如果选择移动到这个位置，那么移动到这个位置所能获得的最大分数，只取决于之前的位置中：

    最后移动的元素为偶数时得分的最大值
            最后移动的元素为奇数时得分的最大值
    只要知道这两个值，我们可以选择从偶数值位置移动过来，也可以从奇数值位置移动过来，得分加上当前数组值。当与当前位置的数组值奇偶性不同时，得分需要额外减去 xxx。两者的最大值就是移动到当前位置可以获得的最大得分。

    我们可以用一个长度为 222 的数组 dp\textit{dp}dp 来保存刚才提到的两个值。在求出当前位置可以获得的最大得分后，更新 dp\textit{dp}dp。最后返回所有位置最大得分的最大值即可。*/
    public static long maxScore1(int[] nums, int x) {
        //记录分别从上一个偶数和奇数位置移动到当前位置的最大得分
        //然后根据当前位置的数是偶数还是奇数更新为对应的"上一个位置"，以供之后使用
        long res = nums[0];
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};//分别从奇数偶数移动过来的最大值
        dp[nums[0] % 2] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int parity = nums[i] % 2;//奇1偶0
            dp[parity] = Math.max(dp[parity] + nums[i], dp[1 - parity] - x + nums[i]);//看从偶数移过来更大，还是奇数移过来更大
           // = cur;//Math.max(dp[parity], cur);//当前从偶数移过来就更新偶数的值，奇数就奇数
            res = Math.max(res, dp[parity]);
        }
        return res;
    }


    //错了
    public static long maxScore(int[] nums, int x) {
        int[]dp=new int[nums.length];//dp[i]存储到达i位置的最大得分
        dp[0]=nums[0];
        int index=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]%2==nums[index]%2){
                dp[i]=dp[index]+=nums[i];
                index=i;
            }else {
                dp[i]=Math.max(dp[index],dp[index]+nums[i]-x);
                if(dp[i]!=dp[index])index=i;
            }
        }
        return dp[dp.length-1];
    }
}

/*
给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。

你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：

如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
对于你访问的位置 i ，你可以获得分数 nums[i] 。
如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
请你返回你能得到的 最大 得分之和。

注意 ，你一开始的分数为 nums[0] 。



示例 1：

输入：nums = [2,3,6,1,9,2], x = 5
输出：13
解释：我们可以按顺序访问数组中的位置：0 -> 2 -> 3 -> 4 。
对应位置的值为 2 ，6 ，1 和 9 。因为 6 和 1 的奇偶性不同，所以下标从 2 -> 3 让你失去 x = 5 分。
总得分为：2 + 6 + 1 + 9 - 5 = 13 。
示例 2：

输入：nums = [2,4,6,8], x = 3
输出：20
解释：数组中的所有元素奇偶性都一样，所以我们可以将每个元素都访问一次，而且不会失去任何分数。
总得分为：2 + 4 + 6 + 8 = 20 。*/
