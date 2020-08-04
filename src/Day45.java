import java.util.ArrayList;
import java.util.List;

@Info(date = "2020-08-04", difficulty = 2,command = "find cycles in DAG")
public class Day45 {
    List<List<Integer>> edges;
    int[] visited;
    boolean finish;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for(int[] p:prerequisites){
            edges.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses && finish; i++) {
            if (visited[i] == 0) dfs(i);
        }
        return finish;
    }

    public void dfs(int u){
        visited[u] = 1;
        for(int v: edges.get(u)){
            if (visited[v] == 0){
                dfs(v);
                if (!finish) return;
            }else if (visited[v] == 1){
                finish = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
