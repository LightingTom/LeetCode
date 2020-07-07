import java.util.ArrayList;

public class Day18 {
    static int summ = 0;
    static ArrayList<Integer> values = new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
    public static boolean hasPathSum_bfs(TreeNode root, int sum){
        if (root == null) return false;
        bfs(root);
        return values.contains(sum);
    }
    public static void bfs(TreeNode root){
        if (root == null) return;
        summ += root.val;
        bfs(root.left);
        bfs(root.right);
        if (root.left == null && root.right == null) values.add(summ);
        summ -= root.val;
    }
}
