public class Day17 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] f = new int[n];
        if (obstacleGrid[0][0] == 0) f[0] = 1;
        else f[0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j-1>0 & obstacleGrid[i][j-1] == 0){
                    f[j] += f[j-1];
                }
            }
        }
        return f[m-1];
    }
}
