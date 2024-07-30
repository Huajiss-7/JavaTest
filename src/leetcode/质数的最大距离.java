package leetcode;

public class 质数的最大距离 {
    public static void main(String[] args) {
        int[]nums={4,2,9,5,3};
        System.out.println(maximumPrimeDifference1(nums));
    }

    public static int maximumPrimeDifference1(int[] nums) {
        int[]isprime = {0,
                0, 1, 1, 0, 1, 0, 1, 0, 0, 0,
                1, 0, 1, 0, 0, 0, 1, 0, 1, 0,
                0, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 0, 0, 0, 1, 0, 0, 0,
                1, 0, 1, 0, 0, 0, 1, 0, 0, 0,
                0, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 0, 0, 0, 1, 0, 0, 0,
                1, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
        };//100以内质数表
        int l = 0, r = nums.length - 1;
        while (l<=r){
            if(isprime[nums[l]]==0){
                l++;
            }
            if(isprime[nums[r]]==0){
                r--;
            }
            if(isprime[nums[l]]==1&&isprime[nums[r]]==1){
                break;
            }
        }
        if(r<l)return -1;
        return r-l;
    }

    //理解错题意了
    public static int maximumPrimeDifference(int[] nums) {
        int[]isprime = {0,
                0, 1, 1, 0, 1, 0, 1, 0, 0, 0,
                1, 0, 1, 0, 0, 0, 1, 0, 1, 0,
                0, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 0, 0, 0, 1, 0, 0, 0,
                1, 0, 1, 0, 0, 0, 1, 0, 0, 0,
                0, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 0, 0, 0, 1, 0, 0, 0,
                1, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 1, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
        };//100以内质数表
        int max = 0;
        int l = 0, r = 0;
        while (r < nums.length-1){
            if(isprime[nums[l]]==0){
                l++;
                r++;//找到第一个质数的位置
            }else {
                r++;
                if(isprime[nums[r]]==1){
                    max=Math.max(max,r-l);
                    l=r;
                }
            }
        }
        return max;
    }

    private static boolean isPrime(int src) {
        double sqrt = Math.sqrt(src);
        if (src < 2) {
            return false;
        }
        if (src == 2 || src == 3) {
            return true;
        }
        if (src % 2 == 0) {// 先判断是否为偶数，若偶数就直接结束程序
            return false;
        }
        for (int i = 3; i <= sqrt; i+=2) {
            if (src % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/*
给你一个整数数组 nums。

返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。



示例 1：

输入： nums = [4,2,9,5,3]

输出： 3

解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。

示例 2：

输入： nums = [4,8,2,8]

输出： 0

解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。*/
