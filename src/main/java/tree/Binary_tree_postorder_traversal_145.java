package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_tree_postorder_traversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            //能访问当前节点的前提是：该节点没有右孩子，或者右孩子已经被访问过
            if (cur.right == null || cur.right == last) {
                stack.pop();
                res.add(cur.val);
                last = cur;
                cur = null; //关键
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}
