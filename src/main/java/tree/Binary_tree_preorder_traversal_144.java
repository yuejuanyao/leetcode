package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_tree_preorder_traversal_144 {
    List<Integer> list = new ArrayList<>();
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        pre(root);
        return list;
    }
    private void pre(TreeNode root){
        if(root == null)
            return;
        list.add(root.val);
        pre(root.left);
        pre(root.right);
    }
    //迭代
    public List<Integer> preorderTraversal_1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop().right;
            }
        }
        return res;
    }
}
