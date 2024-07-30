package leetcode;

public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[]height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    //双指针法
    public static int maxArea(int[]height){
        int max=0;
        int left=0,right=height.length-1;//确定左界右界
        while (left<right){
            int newArea=(right-left)*Math.min(height[right],height[left]);
            max=Math.max(max,newArea);
            if(height[left]<height[right])left++;//如果最左边的比较小，此时和右边的宽度最大，也就是无论右边再是什么值，永远小于当前面积，排除了左边和右边任意柱子的组合情况
            else right--;//反之，排除右边柱子和左边其它柱子的结合情况，只有较小柱子变大，总面积才有可能变大
        }
        return max;
    }

    //超时
    public static int maxArea1(int[] height) {
        int max=0;
        if(height.length==2) return Math.min(height[0],height[1]);
        for (int i = 0; i < height.length; i++) {//当前的长度
            for(int j=i+1;j<height.length;j++){
                int v=(j-i)*Math.min(height[i],height[j]);
                max=Math.max(max,v);
            }
        }
        return max;
    }
}


 /*   给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

        返回容器可以储存的最大水量。

        说明：你不能倾斜容器。

        输入：[1,8,6,2,5,4,8,3,7]
        输出：49
        解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。*/