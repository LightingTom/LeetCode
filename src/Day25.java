import java.util.List;

public class Day25 {
    public int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] opt = new int[n][n];
        opt[0][0] = triangle.get(0).get(0);
        int cur = 1;
        for (int i = 1; i < n; i++) {
            int prev = (cur == 0)?1:0;
            opt[cur][0] = opt[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                opt[cur][j] = Math.min(opt[prev][j],opt[prev][j-1]) + triangle.get(i).get(j);
            }
            opt[cur][i] = opt[prev][i-1] + triangle.get(i).get(i);
            cur = (cur == 0)?1:0;
        }
        int result = opt[1-cur][0];
        for (int i = 1; i < n; i++) {
            if (opt[1-cur][i] < result) result = opt[1-cur][i];
        }
        return result;
    }
}
