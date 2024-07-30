package leetcode;

public class 相同分数的最大操作数目2 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 3, 4};
        System.out.println(maxOperations(nums));
    }


    //抄的
    public static int maxOperations(int[] nums) {
        int n = nums.length;

        // 尝试三种删除操作，分别删除数组的前两个元素、后两个元素以及首尾元素
        int res1 = helper(nums, 2, n - 1, nums[0] + nums[1]); // 删除前两个数
        int res2 = helper(nums, 0, n - 3, nums[n - 2] + nums[n - 1]); // 删除后两个数
        int res3 = helper(nums, 1, n - 2, nums[0] + nums[n - 1]); // 删除第一个和最后一个数

        // 返回最大操作数，并加上第一次操作的1次
        return Math.max(res1, Math.max(res2, res3)) + 1; // 加上第一次操作
    }

    private static int helper(int[] nums, int start, int end, int target) {
        int n = nums.length;
        int[][] f = new int[n + 1][n + 1]; // 动态规划数组，存储操作次数

        // 遍历子数组范围，从end-1到start
        for (int i = end - 1; i >= start; i--) {
            for (int j = i + 1; j <= end; j++) {
                // 检查并更新不同的删除操作
                int r1=0,r2=0,r3=0;
                if (nums[i] + nums[i + 1] == target) { // 删除前两个数
                    r1 = f[i + 2][j + 1] + 1;
                }
                if (nums[j - 1] + nums[j] == target) { // 删除后两个数
                    r2 = f[i][j - 1] + 1;
                }
                if (nums[i] + nums[j] == target) { // 删除第一个和最后一个数
                    r3 = f[i + 1][j] + 1;
                }
                f[i][j + 1]=Math.max(r1,Math.max(r2,r3));
            }
        }
        return f[start][end + 1]; // 返回从start到end+1的最大操作次数
    }


    //超时
    public static int maxOperations2(int[] nums) {
        int l=0,r=nums.length-1;
        int res1=dfs(l+1,r-1,nums,nums[l]+nums[r])+1;
        int res2=dfs(l+2,r,nums,nums[l]+nums[l+1])+1;
        int res3=dfs(l,r-2,nums,nums[r]+nums[r-1])+1;
        return Math.max(res1,Math.max(res2,res3));
    }

    public static int dfs(int l,int r,int[]nums,int mark){
        if(l>=r)return 0;
        int res1=0,res2=0,res3=0;
        if (nums[l] + nums[r] == mark) {
            res1=dfs(l+1,r-1,nums,mark)+1;
        }
        if (nums[l] + nums[l + 1] == mark) {
            res2=dfs(l+2,r,nums,mark)+1;
        }
        if (nums[r] + nums[r - 1] == mark) {
            res3=dfs(l,r-2,nums,mark)+1;
        }
        return Math.max(res1,Math.max(res2,res3));
    }
    /*public static int maxOperations(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];//记录dp[i][j]表示nums[i...j]这个子数组的最大操作数
        int mark = nums[0] + nums[1];
        int r = nums.length - 1, l = 0;
        dp[l][r]=0;
        while (true) {
            int s1 = 0, s2 = 0, s3 = 0;
            if (nums[l] + nums[r] == mark) {
                s1 = dp[l + 1][r - 1] + 1;
                l+=1;
                r-=1;
            }
            if (nums[l] + nums[l + 1] == mark) {
                s2 = dp[l + 2][r] + 1;
                l+=2;
            }
            if (nums[r] + nums[r - 1] == mark) {
                s3 = dp[l][r - 2] + 1;
                r-=2;
            }
            dp[l][r] = Math.max(s1, Math.max(s2, s3));
        }
    }*/
}

    /*给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：

        选择 nums 中最前面两个元素并且删除它们。
        选择 nums 中最后两个元素并且删除它们。
        选择 nums 中第一个和最后一个元素并且删除它们。
        一次操作的 分数 是被删除元素的和。

        在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。

        请你返回按照上述要求 最多 可以进行的操作次数。



        示例 1：

        输入：nums = [3,2,1,2,3,4]
        输出：3
        解释：我们执行以下操作：
        - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
        - 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
        - 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
        由于 nums 为空，我们无法继续进行任何操作。
        示例 2：

        输入：nums = [3,2,6,1,4]
        输出：2
        解释：我们执行以下操作：
        - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
        - 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
        至多进行 2 次操作。*/