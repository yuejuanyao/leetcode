package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_tree_101 {
    //递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return valid(root.left, root.right);
    }

    private boolean valid(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val == right.val)
            return valid(left.right, right.left) && valid(left.left, right.right);
        return false;
    }

    // 迭代，利用连个队列
    public boolean isSymmetric_1(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(root);
        while (!queue1.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            queue1.add(node1.left);
            queue1.add(node1.right);
            queue2.add(node2.right);
            queue2.add(node2.left);
        }
        return true;
    }

}
