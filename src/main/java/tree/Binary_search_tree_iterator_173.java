package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_search_tree_iterator_173 {
    private List<TreeNode> nodes;
    int cur = 0;
    public Binary_search_tree_iterator_173(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        nodes = new ArrayList<TreeNode>();
//        while (!stack.isEmpty() || root != null){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//            if (!stack.isEmpty()){
//                root = stack.pop();
//                nodes.add(root);
//                root = root.right;
//            }
//        }
        nodes = new ArrayList<TreeNode>();
        innerOrder(root);
    }

    private void innerOrder(TreeNode root) {
        if (root == null)
            return;
        innerOrder(root.left);
        nodes.add(root);
        innerOrder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        if (cur< nodes.size())
            return nodes.get(cur++).val;
        else
            return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur < nodes.size();
    }
}
