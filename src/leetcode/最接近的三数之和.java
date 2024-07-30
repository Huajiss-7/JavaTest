package leetcode;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        int[]nums={-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        int minDistance=Math.abs(nums[0]+nums[1]+nums[2]-target);
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])continue;//出现重复元素，跳下一个避免结果重复
            for(int j=i+1,k=nums.length-1;j<k;j++){
                if (j>i+1&&nums[j]==nums[j-1])continue;//同理，枚举时第二个元素重复也跳下一个
                int distance=Math.abs(nums[i]+nums[j]+nums[k]-target);
                if (distance < minDistance) {
                    ans = nums[i] + nums[j] + nums[k];
                    minDistance = distance;
                }
                if(nums[i]+nums[j]+nums[k]>target){
                    j--;//相当于j不变，k向小的位置移动
                    k--;
                }
            }
        }
        return ans;
    }
}

    /*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

        返回这三个数的和。

        假定每组输入只存在恰好一个解。



        示例 1：

        输入：nums = [-1,2,1,-4], target = 1
        输出：2
        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
        示例 2：

        输入：nums = [0,0,0], target = 1
        输出：0*/
