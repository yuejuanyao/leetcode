package tree;

import org.junit.Test;

import java.util.Stack;

public class Lowest_common_ancestor_of_a_binary_search_tree_235 {

    //递归 ，如果两个节点都在该节点的右边，就对右节点递归；右边相同，否则就是该节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int v1 = p.val;
        int v2 = q.val;

        if (v1 > parentVal && v2 > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (v1 < parentVal && v2 < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    //遍历
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        int v1 = p.val;
        int v2 = q.val;
        while (root != null) {
            int parentVal = root.val;
            if (v1 > parentVal && v2 > parentVal) {
                root = root.right;
            } else if (v1 < parentVal && v2 < parentVal) {
                root = root.left;
            } else {
                return root;
            }
        }
        return root;
    }
}
