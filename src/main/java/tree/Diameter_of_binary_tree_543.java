package tree;

public class Diameter_of_binary_tree_543 {
    /*
    最大的距离肯定是过每个根节点的之一，要想知道过根节点的，就必须知道
    左右子树的最大距离，然后相加就是该子树的最大距离，然后保留当前最大的距离
     */
    int max_deep = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root,max_deep);
        return max_deep;
    }

    private int depth(TreeNode root, int max_deep) {
        if (root == null)
            return 0;
        int depth_l = diameterOfBinaryTree(root.left);
        int depth_r = diameterOfBinaryTree(root.right);
        max_deep = Math.max(max_deep,depth_l + depth_r);
        return Math.max(depth_l,depth_r);
    }
}
