package tree;

import java.util.HashMap;
import java.util.Map;

public class Construct_binary_tree_from_preorder_and_inorder_traversal_105 {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = map.get(preorder[preStart]);
        int left = inIndex - inStart;
        root.left = buildSubTree(preorder, preStart + 1, preStart + left, inorder, inStart, inIndex - 1);
        root.right = buildSubTree(preorder, preStart + left + 1, preEnd, inorder, inIndex + 1, inEnd);
        return root;
    }

    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0)
            return null;
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree_1(0, inorder.length - 1);
    }

    private TreeNode buildSubTree_1(int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        int inIndex = map.get(preorder[index]);
        index ++;
        root.left = buildSubTree_1(inStart, inIndex - 1);
        root.right = buildSubTree_1(inIndex + 1, inEnd);
        return root;
    }
}
