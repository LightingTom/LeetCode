import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Day1 {
    public static String serialize(TreeNode root) {
        if (root == null) return "[]";
        String result = "[" + root.val + ",";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        boolean empty = false;
        while (true) {
            empty = true;
            for (int i = 0; i < queue.size(); i++) {
                if (((LinkedList<TreeNode>) queue).get(i) != null){
                    empty = false;
                    break;
                }
            }
            if (empty) break;
            TreeNode target = queue.poll();
            if (target == null) result += "null,";
            else {
                result += (target.val + ",");
                queue.add(target.left);
                queue.add(target.right);
            }
        }
        return result.substring(0, result.length() - 1) + "]";
    }

    public static TreeNode deserialize(String data){
        if (data.equals("[]")) return null;
        String[] arr = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        int cnt = 1;
        Queue<TreeNode> update = new LinkedList<>();
        update.add(root);
        while (!update.isEmpty()){
            for (int i = 0; i < update.size(); i++) {
                TreeNode to_Up = update.poll();
                if (cnt<arr.length){
                    String info = arr[cnt];
                    if (!info.equals("null")){
                        to_Up.left = new TreeNode(Integer.parseInt(info));
                        update.add(to_Up.left);
                    }
                }
                cnt++;
                if (cnt<arr.length){
                    String info = arr[cnt];
                    if (!info.equals("null")) {
                        to_Up.right = new TreeNode(Integer.parseInt(info));
                        update.add(to_Up.right);
                    }
                }
                cnt++;
            }
        }
        return root;
    }

    //Convert the binary tree to the specific format.
    //For example,the following example is [1,2,3,null,null,4,5]
    //Deserialize can convert the format string to a binary tree
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.print(serialize(deserialize(serialize(root))));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x) {
        val = x;
    }
    TreeNode(int x, TreeNode left, TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}