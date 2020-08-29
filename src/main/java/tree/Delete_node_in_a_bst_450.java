package tree;

public class Delete_node_in_a_bst_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null)
                return root.left;
            //左右孩子都不为空, 以左孩子的最右下角的作为体戴，并删除最右下角的
            TreeNode tmp = root;
            TreeNode leftMax = root.left;
            while (leftMax.right != null) {
                tmp = leftMax;
                leftMax = leftMax.right;
            }
            root.val = leftMax.val;
            // tmp变化，则说明肯定左子树肯定有右孩子
            if (tmp != root) {
                tmp.right = leftMax.left;
            } else {
                tmp.left = leftMax.left;
            }
        }
        return root;
    }
}
