package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_binary_tree_226 {
    //递归
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    //广度优先遍历
    public TreeNode invertTree_1(TreeNode root) {
        if(root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tmp = null;
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            tmp =cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
