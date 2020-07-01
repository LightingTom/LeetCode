public class Day12 {
    //Use DP, dp[i][j] represents the answer for A[0:i] and B[0:j]
    //dp[i][j] = dp[i-1][j-1]+1 if A[i-1] == B[j-1]
    public static int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1] == B[j-1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = 0;
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }

    //give two int arrays, find the length of the longest common subarray
    public static void main(String[] args) {
        int[] A = {1};
        int[] B = {1,1};
        System.out.print(findLength(A,B));
    }
}
