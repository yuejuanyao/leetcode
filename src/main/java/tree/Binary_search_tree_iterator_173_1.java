package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_search_tree_iterator_173_1 {
    private Stack<TreeNode> stack;

    public Binary_search_tree_iterator_173_1(TreeNode root) {
        stack = new Stack<>();
        getLeft(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null)
            getLeft(cur.right);
        return cur.val;
    }

    private void getLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.size()>0;
    }
}
