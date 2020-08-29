package tree;


public class Insert_into_a_binary_search_tree_701 {

    // 递归
    public TreeNode insertIntoBST_1(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val == val)
            return root;
        if (val < root.val) {
            root.left = insertIntoBST_1(root.left, val);
        } else {
            root.right = insertIntoBST_1(root.right, val);
        }
        return root;
    }
    //迭代
    public TreeNode insertIntoBST_2(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode pre = root;
        TreeNode cur = root;
        while (cur != null){
            if (cur.val == val)
                return root;
            pre = cur;
            if (val < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if (val < pre.val)
            pre.left = new TreeNode(val);
        else
            pre.right = new TreeNode(val);
        return root;
    }
}
