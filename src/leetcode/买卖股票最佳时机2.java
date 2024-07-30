package leetcode;

public class 买卖股票最佳时机2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        买卖股票最佳时机2 x = new 买卖股票最佳时机2();
        System.out.println(x.maxProfit(prices));
        //方法二
        System.out.println(maxProfit1(prices));
    }

    //暴力搜索
    private int res;

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        this.res = 0;
        dfs(prices, 0, 0, res);
        return res;
    }

    //status 0表示不持有股票，1表示持有股票
    public void dfs(int[] prices, int index, int status, int profit) {
        //每天对应三种状态，1.无论当前持不持有股票不操作，2.如果持有股票卖出，3.如果不持有股票买入
        if (index == prices.length) {
            res = Math.max(res, profit);
            return;
        }
        //当天不操作
        dfs(prices, index + 1, status, profit);
        //不持有股票买入
        if (status == 0) dfs(prices, index + 1, 1, profit - prices[index]);//买入后下一天的状态就变成1持有了
            // 持有股票卖出
        else dfs(prices, index, 0, profit + prices[index]);
    }

    //动态规划
    public static int maxProfit1(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2]; //表示每一天两种状态分别的最大的现金数,dp[i][0]表示第i+1天，持有现金，dp[i][1]表示持有股票
        dp[0][0] = 0; //第一天什么都不做，没有钱
        dp[0][1] = -prices[0]; //第一天买入股票，欠债去买股票，手上的现金为股价的负数
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); //当天不持股的最大现金为如果前一天也没持股，那就维持不动，或者前一天持股了，卖掉更挣钱的较大值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); //当天持股最优值为，如果前一天持股更优就继续持有，如果前一天没有持股，那就买入股票
        }//这样一步一步向后推移，每次选择都代表选择了之前所有的最优情况，只有这样才能达到当前最优情况
        return dp[prices.length - 1][0]; //最后一天持有现金的状态就是最大利润
    }

    //空间优化
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

    //贪心算法
    /*「贪心算法」 和 「动态规划」、「回溯搜索」 算法一样，完成一件事情，是 分步决策 的；
            「贪心算法」 在每一步总是做出在当前看来最好的选择，我是这样理解 「最好」 这两个字的意思：
            「最好」 的意思往往根据题目而来，可能是 「最小」，也可能是 「最大」；
    贪心算法和动态规划相比，它既不看前面（也就是说它不需要从前面的状态转移过来），也不看后面（无后效性，后面的选择不会对前面的选择有影响），因此贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的；
    这道题 「贪心」 的地方在于，对于 「今天的股价 - 昨天的股价」，得到的结果有 3 种可能：① 正数，② 000，③负数。贪心算法的决策是： 只加正数 。
*/
    public static int maxProfit3(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                result += prices[i] - prices[i - 1];

        }
        return result;
    }

}

    /*给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

        在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

        返回 你能获得的 最大 利润 。



        示例 1：

        输入：prices = [7,1,5,3,6,4]
        输出：7
        解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
        随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
        总利润为 4 + 3 = 7 。
        示例 2：

        输入：prices = [1,2,3,4,5]
        输出：4
        解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
        总利润为 4 。
        示例 3：

        输入：prices = [7,6,4,3,1]
        输出：0
        解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。*/
