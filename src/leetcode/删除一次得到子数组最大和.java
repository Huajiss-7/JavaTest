package leetcode;

import java.util.Arrays;

public class 删除一次得到子数组最大和 {
    public static void main(String[] args) {
        int[]arr={1,-2,0,-1,3};
        System.out.println(maximumSum1(arr));
    }

    public static int maximumSum1(int[] arr) {
        int ans=Integer.MIN_VALUE;
        int[][]dp=new int[arr.length+1][2];//dp[i][j]表示右边界为i-1情况下，之前有没有删除过数
        //dp[0]表示递归终止边界，右边界为-1情况
        Arrays.fill(dp[0],Integer.MIN_VALUE/2);//除2防止负数相加溢出
        for (int i = 0; i < arr.length; i++) {
            dp[i+1][0]=Math.max(dp[i][0]+arr[i],arr[i]);//一个也不删，表示为前面加上前面的更大，或者只算当前的更大
            dp[i+1][1]=Math.max(dp[i][1]+arr[i],dp[i][0]);//删一个，可以表示为前面删过了，或前面没删，删除当前的数
            ans=Math.max(ans,Math.max(dp[i+1][0],dp[i+1][1]));
        }
        return ans;
    }

    //理解错题意了，这是删掉一整个连续子数组得到的最大值
    public static int maximumSum(int[] arr) {
        int min=Integer.MAX_VALUE;
        int nowVal=0;
        int totalSum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0) {
                nowVal+=arr[i];
                min=Math.min(min,nowVal);
            }else {
                nowVal=0;
                min=Math.min(arr[i],min);
            }
            totalSum+=arr[i];
        }
        return totalSum-min;
    }
}

/*
给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。

注意，删除一个元素后，子数组 不能为空。



示例 1：

输入：arr = [1,-2,0,3]
输出：4
解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
示例 2：

输入：arr = [1,-2,-2,3]
输出：3
解释：我们直接选出 [3]，这就是最大和。
示例 3：

输入：arr = [-1,-1,-1,-1]
输出：-1
解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。*/
