import java.util.LinkedList;
import java.util.List;

public class Day32 {
    public static List<TreeNode> generateTrees(int n){
        if (n == 0) return new LinkedList<TreeNode>();
        return generate(1,n);
    }
    public static List<TreeNode> generate(int start, int end){
        List<TreeNode> all = new LinkedList<TreeNode>();
        if (start > end) {
            all.add(null);
            return all;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start,i-1);
            List<TreeNode> right = generate(i+1,end);
            for (TreeNode l_node:left){
                for (TreeNode r_node: right){
                    TreeNode curr = new TreeNode(i);
                    curr.left = l_node;
                    curr.right = r_node;
                    all.add(curr);
                }
            }
        }
        return all;
    }

    public static void main(String[] args) {
        generateTrees(3);
    }
}
