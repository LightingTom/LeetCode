public class Day21 {
    //这种带状态的dp不需要考虑状态之间如何相互转移，只需要考虑每种状态自身的状态转移方程
    //把所有都算出来，然后求最大即可
    public static int maxProfit(int[] prices){
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            //第i天持有一支股票，可能第i-1天已经持有，或者第i-1天买入
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]);
            //第i天结束处于冷冻期，说明第i天卖了股票
            dp[i][1] = dp[i-1][0]+prices[i];
            //第i天没有股票，第i-1天可能在或不在冷冻期
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }
}
