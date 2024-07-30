package leetcode;

public class 找出满足差值条件的下标 {
    public static void main(String[] args) {
        int[]nums={5,1,4,1};
        for (int i : findIndices(nums, 2, 4)) {
            System.out.print(i+" ");
        }
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if(nums.length==1&&indexDifference==0&&valueDifference==0)return new int[]{0,0};
        int[]ans={-1,-1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(j-i>=indexDifference&&Math.abs(nums[i]-nums[j])>=valueDifference){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }
}

/*
给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。

        你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：

        abs(i - j) >= indexDifference 且
        abs(nums[i] - nums[j]) >= valueDifference
        返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。

        注意：i 和 j 可能 相等 。



        示例 1：

        输入：nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
        输出：[0,3]
        解释：在示例中，可以选择 i = 0 和 j = 3 。
        abs(0 - 3) >= 2 且 abs(nums[0] - nums[3]) >= 4 。
        因此，[0,3] 是一个符合题目要求的答案。
        [3,0] 也是符合题目要求的答案。
        示例 2：

        输入：nums = [2,1], indexDifference = 0, valueDifference = 0
        输出：[0,0]
        解释：
        在示例中，可以选择 i = 0 和 j = 0 。
        abs(0 - 0) >= 0 且 abs(nums[0] - nums[0]) >= 0 。
        因此，[0,0] 是一个符合题目要求的答案。
        [0,1]、[1,0] 和 [1,1] 也是符合题目要求的答案。
        示例 3：

        输入：nums = [1,2,3], indexDifference = 2, valueDifference = 4
        输出：[-1,-1]
        解释：在示例中，可以证明无法找出 2 个满足所有条件的下标。
        因此，返回 [-1,-1] 。*/
