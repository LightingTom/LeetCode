import java.util.LinkedList;
import java.util.List;

@Info(date = "2020-08-02", difficulty = 0, command = "easy one")
public class Day43 {
    public void flatten(TreeNode root){
        List<TreeNode> list = new LinkedList<>();
        traverse(root,list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i-1);
            TreeNode next = list.get(i);
            prev.left = null;
            prev.right = next;
        }
    }

    public void traverse(TreeNode root, List<TreeNode> list){
        if (root == null) return;
        list.add(root);
        traverse(root.left,list);
        traverse(root.right,list);
    }
}
