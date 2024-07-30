package leetcode;

import java.util.Arrays;

public class 打家劫舍 {
    public static void main(String[] args) {
        int[]nums={2,7,9,3,1};
        System.out.println(rob1(nums));
        int[]numss={2,3,2};
        System.out.println(rob2(numss));

    }

    public static int rob(int[] nums) {
        if(nums.length==0)return 0;
        int[]sum=new int[nums.length+1];//sum[i]表示前i个房间偷到的最大金额，因为要表示前0间，所以长度要加一
        sum[0]=0;//前0间金额就是0
        sum[1]=nums[0];//前一间的最大金额就是这一间
        for (int i = 2; i <= nums.length; i++) {//nums的第*个位置一直比i小一位
            sum[i]=Math.max(sum[i-1],sum[i-2]+nums[i-1]);//前i间的最大值等于偷前i-1间的最大值，第i间不偷，或者偷前i-2间的最大值，再加上偷第i间的值，从二者中选最大的
        }
        return sum[nums.length];//返回前nums.length间的最大值
    }

    //空间优化
    public static int rob1(int[]nums){
        if(nums.length==0)return 0;
        int prev=0;//记录前k-2间的最大值
        int curr=nums[0];//记录前k-1间的最大值
        for (int i = 2; i <= nums.length; i++) {
            int temp=Math.max(prev+nums[i-1],curr);//temp表示前k间的最大值
            prev=curr;
            curr=temp;
        }
        return curr;
    }

    //打家劫舍II  房子变成环形的，最后一间和第一间挨着
    public static int rob2(int[]nums){
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];//不然copy生成sum2会越界
        //问题拆解成第一间可偷，最后一间不能偷，偷盗范围为第一间到第n-1间
        //和第一间不可偷，最后一间可偷，偷盗范围为第二间到第n间
        int sum1=rob1(Arrays.copyOfRange(nums,0,nums.length-1));//索引包头不包尾
        int sum2 = rob1(Arrays.copyOfRange(nums, 1, nums.length));//alt+enter快速生成左边变量
        return Math.max(sum1,sum2);
    }

}

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

        给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



        示例 1：

        输入：[1,2,3,1]
        输出：4
        解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
        偷窃到的最高金额 = 1 + 3 = 4 。
        示例 2：

        输入：[2,7,9,3,1]
        输出：12
        解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
        偷窃到的最高金额 = 2 + 9 + 1 = 12 。

        动态规划解析：https://leetcode.cn/problems/house-robber/solutions/138131/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
*/
