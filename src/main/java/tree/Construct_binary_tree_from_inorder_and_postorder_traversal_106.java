package tree;

import java.util.HashMap;
import java.util.Map;

public class Construct_binary_tree_from_inorder_and_postorder_traversal_106 {
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length <= 0 || postorder.length <= 0)
            return null;
        this.inorder = inorder;
        this.postorder = postorder;
        this.index = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int start, int end) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(postorder[index]);
        int inIndex = map.get(postorder[index]);
        index--;
        root.right = buildSubTree(inIndex + 1,end);
        root.left = buildSubTree(start, inIndex - 1);
        return root;
    }
}
