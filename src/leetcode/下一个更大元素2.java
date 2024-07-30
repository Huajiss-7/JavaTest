package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 下一个更大元素2 {
    public static void main(String[] args) {
        int[]nums={1,2,3,4,3};
        Arrays.stream(nextGreaterElements1(nums)).forEach(System.out::println);
    }

    //单调栈法
    //暴力的O(n*n)优化为O(n)
    public static int[] nextGreaterElements1(int[] nums){
        Deque<Integer>stack=new LinkedList<>();//存储的是下标，遇到小的入栈，遇到大的出栈，替换当前下标元素
        int[]res=new int[nums.length];
        Arrays.fill(res,-1);
        //如果有单调递减段，可大幅节约暴力遍历时间，因为单调递减段(栈中元素的一部分)拥有同样的更大值
        //死活弹不出栈的元素就是最大值，他的位置就是默认的-1
        for (int i = 0; i < nums.length*2-1; i++) {//循环数组，相当于原数组最多循环两遍
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i%nums.length]){//遇到比栈顶大的就弹出，直到栈顶大于它或栈为空
                res[stack.pop()]=nums[i%nums.length];
            }
            stack.push(i%nums.length);//比栈顶小了就入栈
        }

        return res;
    }



    //暴力法
    public static int[] nextGreaterElements(int[] nums) {
        int i=0;
        int[]ans=new int[nums.length];
        while (i<nums.length){
            int biggerPoint=(i+1)%nums.length;
            int j=0;
            while (nums[biggerPoint]<=nums[i]&&j<nums.length){
                biggerPoint++;
                biggerPoint%=nums.length;
                j++;//限制最多查询数组一遍，此时找不到，当前值就是最大值
            }
            if(j==nums.length){
                ans[i]=-1;
            }
           else ans[i]=nums[biggerPoint];
           i++;
        }
        return ans;
    }
}

/*
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。



示例 1:

输入: nums = [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
示例 2:

输入: nums = [1,2,3,4,3]
输出: [2,3,4,-1,4]*/
