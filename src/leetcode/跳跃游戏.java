package leetcode;

public class 跳跃游戏 {
    public static void main(String[] args) {
        int[]nums1={2,3,1,1,4};
        System.out.println(canJump(nums1));
        int[]nums2={3,2,1,0,4};
        System.out.println(canJump(nums2));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length<2)return true;//只有一个元素以下，一定能达到最后位置
        boolean[]flag=new boolean[nums.length];//记录每一个位置是否能达到，没初始化默认值就是false
        flag[0]=true;
        for (int i = 0; i < nums.length; i++) {
            if(flag[i]){
                for(int j=i+1;j<i+1+nums[i]&&j<nums.length;j++){
                    flag[j]=true;
                }
            }
        }
        return flag[nums.length-1];
    }

    public static boolean canJump1(int[] nums) {
        /*如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
        可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
        如果可以一直跳到最后，就成功了*/
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }


}

   /* 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。



        示例 1：

        输入：nums = [2,3,1,1,4]
        输出：true
        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        示例 2：

        输入：nums = [3,2,1,0,4]
        输出：false
        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。*/
