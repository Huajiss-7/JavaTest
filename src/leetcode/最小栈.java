package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class 最小栈 {
    private Deque<Integer> minStack;
    private Deque<Integer> minValue;//记录目前栈中最小值
    public 最小栈() {
        this.minStack=new LinkedList<>();
        this.minValue=new LinkedList<>();
        minValue.push(Integer.MAX_VALUE);//防止第一次push时peek报错
    }

    public void push(int val) {
        minStack.push(val);
        minValue.push(Math.min(val,minValue.peek()));
    }

    public void pop() {
        minStack.pop();
        minValue.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

        实现 MinStack 类:

        MinStack() 初始化堆栈对象。
        void push(int val) 将元素val推入堆栈。
        void pop() 删除堆栈顶部的元素。
        int top() 获取堆栈顶部的元素。
        int getMin() 获取堆栈中的最小元素。


        示例 1:

        输入：
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]

        输出：
        [null,null,null,null,-3,null,0,-2]

        解释：
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   --> 返回 -3.
        minStack.pop();
        minStack.top();      --> 返回 0.
        minStack.getMin();   --> 返回 -2.*/
