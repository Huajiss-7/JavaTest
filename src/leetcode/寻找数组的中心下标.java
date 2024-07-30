package leetcode;

public class 寻找数组的中心下标 {
    public static void main(String[] args) {
        int[]nums={1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        if(nums.length<2)return 0;
        if(nums.length==2) {
            if(nums[0]==0)return nums[1]==0?0:1;
            else if(nums[1]==0)return 0;
            else return -1;
        }
        int[]preSum=new int[nums.length];
        preSum[0]=nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i]=preSum[i-1]+nums[i];
        }

        // 检查第一个元素是否是 pivot 索引
        if (preSum[nums.length - 1] - preSum[0] == 0) return 0;

        for (int i = 1; i < preSum.length; i++) {
            if(preSum[preSum.length-1]-preSum[i]==preSum[i-1])return i;
        }
        return -1;
    }

    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int tot = 0;
        for (int x: nums) tot += x;

        int pre = 0;
        for (int i = 0; i < n; i ++ ) {
            if (pre == tot - pre - nums[i])
                return i;
            pre += nums[i];
        }

        return -1;
    }
}

/*
给你一个整数数组 nums ，请计算数组的 中心下标 。

数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。

如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。

如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。



示例 1：

输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
中心下标是 3 。
左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
示例 2：

输入：nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心下标。
示例 3：

输入：nums = [2, 1, -1]
输出：0
解释：
中心下标是 0 。
左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。*/
