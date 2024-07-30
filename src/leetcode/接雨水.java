package leetcode;
//困难
public class 接雨水 {
    public static void main(String[] args) {
        int[]height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    /**
     * 把每个下标看作一个水桶，每个下标的储水量为其左右最大值的较小值-当前高度
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if(height.length<2){return 0;}
        int n = height.length;
        int[]prefix=new int[n];
        int[]suffix=new int[n];
        prefix[1]=height[0];
        for (int i = 2; i < n; i++) {
            prefix[i]=Math.max(prefix[i-1],height[i-1]);
        }
        suffix[n-1]=height[n-2];
        for (int i = n-2; i > 0; i--) {
            suffix[i]=Math.max(suffix[i+1],height[i+1]);
        }
        int res=0;
        for (int i = 1; i < n-1; i++) {
            int temp=Math.min(suffix[i],prefix[i]);
            if(temp>height[i])res+=temp-height[i];
        }
        return res;
    }

    //双指针
    public int trap2(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0; // 前缀最大值，随着左指针 left 的移动而更新
        int sufMax = 0; // 后缀最大值，随着右指针 right 的移动而更新
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return ans;
    }

}

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9*/
