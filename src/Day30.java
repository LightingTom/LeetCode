import java.util.Arrays;

public class Day30 {
    private int[][] rec;
    private int[] val;
    public int maxCoins(int[] nums){
        int n = nums.length;
        val = new int[n+2];
        val[0] = val[n+1] = 1;
        for (int i = 0; i < n; i++) {
            val[i+1] = nums[i];
        }
        rec = new int[n+2][n+2];
        for (int i = 0; i <= n+1; i++) {
            Arrays.fill(rec[i],-1);
        }
        return solve(0,n+1);
    }

    public int solve(int i,int j){
        if (i>=j-1) return 0;
        if (rec[i][j] != -1) return rec[i][j];
        for (int k = i+1; k < j; k++) {
            int sum = val[i] * val[k] * val[j];
            sum += solve(i,k) + solve(k,j);
            rec[i][j] = Math.max(sum,rec[i][j]);
        }
        return rec[i][j];
    }
}
