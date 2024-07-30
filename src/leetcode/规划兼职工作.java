package leetcode;

import java.util.Arrays;
import java.util.Comparator;

//困难
public class 规划兼职工作 {
    public static void main(String[] args) {
        int[]startTime={1,2,3,3};
        int[]endTime={3,4,5,6};
        int[]profit={50,10,40,70};
        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][]jobs=new int[startTime.length+1][];//第一维是开始时间，第二维是结束时间,第二维长度不写，这样可以每个第二维的长度不一样
        for (int i = 1; i < jobs.length; i++) {
            jobs[i]=new int[]{startTime[i-1],endTime[i-1],profit[i-1]};//把0号位置空出来，和下面的dp对齐
        }
        jobs[0]=new int[]{0,0,0};
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });//按照结束时间排序，o[]表示每个第二维的数组，o[0]是开始时间

        int[]dp=new int[startTime.length+1];//记录到每个截止日期的利益最大值
        dp[0]=0;
        for (int i = 1; i < jobs.length; i++) {
            int j=binarySearch(jobs,i,jobs[i][0]);//找到最大不超过job[i]开始时间，的结束时间，dp[j]就是这个结束时间的最大利益值
            dp[i]=Math.max(dp[i-1],dp[j]+jobs[i][2]);
        }
        return dp[dp.length-1];
    }

    public static int binarySearch(int[][]nums,int right,int upper){
        int left=-1;
        while (left+1<right){
            int mid=(left+right)/2;
            if(nums[mid][1]<=upper)left=mid;
            else right=mid;
        }
        return left;
    }
}

/*
你打算利用空闲时间来做兼职工作赚些零花钱。

        这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。

        给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。

        注意，时间上出现重叠的 2 份工作不能同时进行。

        如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。



        示例 1：



        输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
        输出：120
        解释：
        我们选出第 1 份和第 4 份工作，
        时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
        示例 2：



        输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
        输出：150
        解释：
        我们选择第 1，4，5 份工作。
        共获得报酬 150 = 20 + 70 + 60。
        示例 3：



        输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
        输出：6*/
