import java.util.Arrays;

public class Day23 {
    //can only dp from right-bottom to left-top
    //else we cannot make sure the knight can get to the princess safely
    public int calculateMinHP(int[][] dungeon){
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[n][m-1] = 1;
        dp[n-1][m] = 1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int min = (dp[i+1][j]<dp[i][j+1])?dp[i+1][j]:dp[i][j+1];
                dp[i][j] = Math.max(min-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
