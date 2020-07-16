public class Day27 {
    private int[] colors;
    private boolean valid;
    public boolean isBipartite(int[][] graph){
        int n = graph.length;
        colors = new int[n];
        valid = true;
        for (int i = 0; i < n&&valid; i++) {
            if (colors[i] == 0) dfs(graph,1,i);
        }
        return valid;
    }
    public void dfs(int[][] graph, int color, int idx){
        colors[idx] = color;
        int next_color = (color==1)?2:1;
        for (int i = 0; i < graph[idx].length; i++) {
            if (colors[graph[idx][i]]==0){
                dfs(graph,next_color,graph[idx][i]);
                if (!valid) return;
            }else if (colors[graph[idx][i]] != next_color){
                valid = false;
                return;
            }
        }
    }
}
