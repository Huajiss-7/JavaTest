package leetcode;

import java.util.Stack;

public class 找出最具竞争力的子序列 {
    public static void main(String[] args) {
        int[]nums={3,5,2,6};
        for (int i : mostCompetitive(nums, 2)) {
            System.out.print(i+" ");
        }
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer>stack=new Stack<>();//单调栈，保持递增或递减的栈，如果遇到比栈顶大(小)的元素则弹出，直到合适才压入新元素
        //stack.push(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty()&&stack.peek()>nums[i]&&stack.size()+nums.length-i-1>=k){//剩余元素可以填满k个位置
                stack.pop();
            }
            if(stack.size()<k)stack.push(nums[i]);
        }
        int[]ans=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }

    /*public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer>stack=new Stack<>();//单调栈，保持递增或递减的栈，如果遇到比栈顶大(小)的元素则弹出，直到合适才压入新元素
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            while (stack.size()+nums.length-i-1>=k&&stack.peek()>nums[i]){//剩余元素可以填满k个位置
                stack.pop();
            }
            if(stack.size()<k)stack.push(nums[i]);
        }
        int[]ans=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }*/
}

    /*给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。

        数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。

        在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。



        示例 1：

        输入：nums = [3,5,2,6], k = 2
        输出：[2,6]
        解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
        示例 2：

        输入：nums = [2,4,3,3,5,4,9,6], k = 4
        输出：[2,3,3,4]*/