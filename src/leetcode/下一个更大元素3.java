package leetcode;

import java.util.*;

public class 下一个更大元素3 {
    public static void main(String[] args) {
        //System.out.println(nextGreaterElement(230241));
        System.out.println(nextGreaterElement(2147483476));
    }

    public static int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }//此时的数倒着存在list中
        //System.out.println(list);
        Stack<Integer> stack = new Stack<>();//最小栈（完全没必要）
        int i = 1;
        stack.push(0);
        while (i < list.size() && !stack.isEmpty() && list.get(stack.peek()) <= list.get(i)) {//遇到比栈顶小的才会停止
            i++;
        }
        if(stack.isEmpty()||i==list.size()) return -1;
        int temp = stack.pop();
        int t2 = list.get(i);
        list.add(i, list.get(temp));
        list.remove(i+1);
        list.add(temp, t2);
        list.remove(temp+1);

        Integer[]nums = new Integer[i];//对交换后，最后i-1位降序排列
        for (int j = 0; j < i; j++) {
            nums[j]=list.get(j);
        }
        Arrays.sort(nums,Collections.reverseOrder());

        for (int k = 0; k < nums.length; k++) {
            list.set(k,nums[k]);
        }

        StringBuffer sb = new StringBuffer();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return Long.parseLong(sb.reverse().toString())>Integer.MAX_VALUE?-1:Integer.parseInt(sb.toString());
    }

    //抄的
    //倒着找第一个出现的升序（正着最后出现的升序）
    //然后对其后面从小到大排序
    //在排序好的元素里找到第一个大于升序(值最小的大于目标元素的元素)
    //交换其位置
    public static int nextGreaterElement1(int n) {
        // 转换成 char[]
        char[] s = String.valueOf(n).toCharArray();
        // 从后向前查找第一个相邻升序的元素对
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] > s[i - 1]) {
                // 从 i 开始排序
                Arrays.sort(s, i, s.length);
                // 从 i 开始向后找第一个比 i - 1 大的元素
                for (int j = i; j < s.length; j++) {
                    // 找到就交换
                    if (s[j] > s[i - 1]) {
                        char t = s[i - 1];
                        s[i - 1] = s[j];
                        s[j] = t;
                        // 判断是否为 32 位整数
                        long ans = Long.parseLong(String.valueOf(s));
                        if (ans > Integer.MAX_VALUE) return -1;
                        return (int) ans;
                    }
                }
            }
        }
        // 没有下一个更大的元素
        return -1;
    }

}

/*
给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。

注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。



示例 1：

输入：n = 12
输出：21
示例 2：

输入：n = 21
输出：-1*/
