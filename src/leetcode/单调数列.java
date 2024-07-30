package leetcode;

import java.util.Arrays;

public class 单调数列{
    public static void main(String[] args) {
        int[]nums={1,2,3,4,5,6};
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        int[]arr=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        if(Arrays.compare(arr,nums)==0)return true;
        reverseArr(arr);
        if(Arrays.compare(arr,nums)==0)return true;
        else return false;
    }

    public static void reverseArr(int[]arr){
        int front=0,back=arr.length-1;
        while (front<back){
            int temp=arr[front];
            arr[front]=arr[back];
            arr[back]=temp;
            front++;
            back--;
        }
    }
}

/*如果数组是单调递增或单调递减的，那么它是 单调 的。

        如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。

        当给定的数组 nums 是单调数组时返回 true，否则返回 false。



        示例 1：

        输入：nums = [1,2,2,3]
        输出：true
        示例 2：

        输入：nums = [6,5,4,4]
        输出：true
        示例 3：

        输入：nums = [1,3,2]
        输出：false*/
