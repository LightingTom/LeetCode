@Info(date = "2020-07-30",difficulty = 1,command = "easy dp")
public class Day40 {
    public int integerBreak(int n){
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int opt = Math.max(j*dp[i-j],j*(i-j));
                if (opt > max) max = opt;
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
