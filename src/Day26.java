public class Day26 {
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    //这个式子也有个递推公式（卡兰塔数）
    //k(n) = (2*(2n+1)/(n+2))*k(n-1)
}
