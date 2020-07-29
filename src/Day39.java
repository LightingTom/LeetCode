import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Leetcode: LCP 13
@Info(date = "2020-07-29", difficulty = 5, command = "Special dp, need to review")
public class Day39 {
    int m, n;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimalSteps(String[] maze) {
        m = maze.length;
        n = maze[0].length();
        List<int[]> buttons = new LinkedList<>();
        List<int[]> stones = new LinkedList<>();
        int sx = -1;
        int sy = -1;
        int tx = -1;
        int ty = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i].charAt(j) == 'M') {
                    buttons.add(new int[]{i, j});
                } else if (maze[i].charAt(j) == 'O') {
                    stones.add(new int[]{i, j});
                } else if (maze[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if (maze[i].charAt(j) == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        int bs = buttons.size();
        int ss = stones.size();
        int[][] startDis = bfs(sx, sy, maze);

        if (bs == 0) return startDis[tx][ty];

        int[][] dist = new int[bs][bs + 2];
        for (int i = 0; i < bs; i++) {
            Arrays.fill(dist[i],-1);
        }

        int[][][] record = new int[bs][][];
        for (int i = 0; i < bs; i++) {
            int[][] d = bfs(buttons.get(i)[0],buttons.get(i)[1],maze);
            record[i] = d;
            dist[i][bs+1] = d[tx][ty];
        }

        for (int i = 0; i < bs; i++) {
            int tmp = -1;
            for (int j = 0; j < ss; j++) {
                int stone_x = stones.get(j)[0],stone_y = stones.get(j)[1];
                if (record[i][stone_x][stone_y] != -1 && startDis[stone_x][stone_y] != -1){
                    if (tmp == -1 || tmp > startDis[stone_x][stone_y] + record[i][stone_x][stone_y])
                        tmp = startDis[stone_x][stone_y] + record[i][stone_x][stone_y];
                }
            }
            dist[i][bs] = tmp;
            for (int j = i+1; j < bs; j++) {
                int tem = -1;
                for (int k = 0; k < ss; k++) {
                    int stone_x = stones.get(k)[0], stone_y = stones.get(k)[1];
                    if (record[i][stone_x][stone_y] != -1 && record[j][stone_x][stone_y] != -1){
                        if (tem == -1 || tem > record[i][stone_x][stone_y] + record[j][stone_x][stone_y])
                            tem = record[i][stone_x][stone_y] + record[j][stone_x][stone_y];
                    }
                }
                dist[i][j] = tem;
                dist[j][i] = tem;
            }
        }

        for (int i = 0; i < bs; i++) {
            if (dist[i][bs] == -1 || dist[i][bs+1] == -1)
                return -1;
        }

        // dp 数组， -1 代表没有遍历到
        int[][] dp = new int[1 << bs][bs];
        for (int i = 0; i < 1 << bs; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < bs; i++) {
            dp[1 << i][i] = dist[i][bs];
        }

        // 由于更新的状态都比未更新的大，所以直接从小到大遍历即可
        for (int mask = 1; mask < (1 << bs); mask++) {
            for (int i = 0; i < bs; i++) {
                // 当前 dp 是合法的
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < bs; j++) {
                        // j 不在 mask 里
                        if ((mask & (1 << j)) == 0) {
                            int next = mask | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) {
                                dp[next][j] = dp[mask][i] + dist[i][j];
                            }
                        }
                    }
                }
            }
        }

        int ret = -1;
        int finalMask = (1 << bs) - 1;
        for (int i = 0; i < bs; i++) {
            if (ret == -1 || ret > dp[finalMask][i] + dist[i][bs + 1]) {
                ret = dp[finalMask][i] + dist[i][bs + 1];
            }
        }

        return ret;
    }

    public int[][] bfs(int x, int y, String[] maze) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        res[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] target = queue.poll();
            int cur_x = target[0];
            int cur_y = target[1];
            for (int i = 0; i < 4; i++) {
                int n_x = cur_x + dir[i][0];
                int n_y = cur_y + dir[i][1];
                if (valid(n_x, n_y) &&res[n_x][n_y] == -1 && maze[n_x].charAt(n_y) != '#') {
                    res[n_x][n_y] = res[cur_x][cur_y] + 1;
                    queue.offer(new int[]{n_x, n_y});
                }
            }
        }
        return res;
    }

    public boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public static void main(String[] args) {
        Day39 d = new Day39();
        String[] maze = {"S#O","M..","M.T"};
        int ans = d.minimalSteps(maze);
    }
}
