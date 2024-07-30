package leetcode;

public class 搜索插入位置 {
    public static void main(String[] args) {
        int[]nums={1,3,5,6};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }else return mid;
        }
        //返回left表示如果没有这个元素，这个元素应该在的位置，也可以return -1;之类的表示没找到
        return left;//为什么直接return left；因为如果上面的没有返回return middle，说明最后一定是，left>right从而跳出循环的，在此之前是left=right，如果最后是right-1导致的left>right，说明原来的right位置是大于target的，所以返回原来的right位置即left位置；如果最后是left+1导致的left>right,说明是原来的的left=right这个位置小于target，而right能移动到这个位置，说明此位置右侧是大于target的，left现在加1就移动到了这样的位置，返回left即可
    }
}

/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

        请必须使用时间复杂度为 O(log n) 的算法。



        示例 1:

        输入: nums = [1,3,5,6], target = 5
        输出: 2
        示例 2:

        输入: nums = [1,3,5,6], target = 2
        输出: 1
        示例 3:

        输入: nums = [1,3,5,6], target = 7
        输出: 4*/
