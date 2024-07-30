package leetcode;

import java.util.HashSet;

public class 存在重复元素 {
    public static void main(String[] args) {
        int[]nums={1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}

   /* 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。


        示例 1：

        输入：nums = [1,2,3,1]
        输出：true
        示例 2：

        输入：nums = [1,2,3,4]
        输出：false
        示例 3：

        输入：nums = [1,1,1,3,3,4,3,2,4,2]
        输出：true*/
