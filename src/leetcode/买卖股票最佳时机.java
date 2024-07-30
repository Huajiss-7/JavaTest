package leetcode;

public class 买卖股票最佳时机 {
    public static void main(String[] args) {
        int[]prices={7,1,5,3,6,4};
        int[]prices1={2,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int max=0;
        int left=0;//记录最小值下标
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<prices[left]){
                left=i;//如果当前值比最小值小，当前值就是最小值
            }
            max=Math.max(max,prices[i]-prices[left]);//判断未来的值与最小值的差值，是否比以前的差值大
        }
        return max;
    }
    //超时
    public static int maxProfit1(int[] prices) {
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j=i+1;j<prices.length;j++){
                max=Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }
}


    /*给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

        你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

        返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。



        示例 1：

        输入：[7,1,5,3,6,4]
        输出：5
        解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
        示例 2：

        输入：prices = [7,6,4,3,1]
        输出：0
        解释：在这种情况下, 没有交易完成, 所以最大利润为 0。*/
