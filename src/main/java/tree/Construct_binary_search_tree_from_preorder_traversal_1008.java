package tree;

import java.util.Stack;

public class Construct_binary_search_tree_from_preorder_traversal_1008 {
    int[] preorder = null;
    int index = 0;
    int n;

    //方法1 回溯法
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 0)
            return null;
        this.preorder = preorder;
        this.n = preorder.length;
        return buildTree(null, null);
    }

    //其实就是回溯
    private TreeNode buildTree(Integer low, Integer high) {
        if (index == n)
            return null;
        int value = preorder[index];
        if ((low != null && value < low) || (high != null && value > high))
            return null;
        index++;
        TreeNode root = new TreeNode(value);
        root.left = buildTree(low, value);
        root.right = buildTree(value, high);
        return root;
    }

    //方法二，根据区间进行递归
    public TreeNode bstFromPreorder_1(int[] preorder) {
        if (preorder == null || preorder.length <= 0)
            return null;
        return buildTree_1(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree_1(int[] preorder, Integer start, Integer end) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        for (; index <= end; index++) {
            if (preorder[index] > preorder[start])
                break;
        }
        root.left = buildTree_1(preorder, start + 1, index - 1);
        root.right = buildTree_1(preorder, index, end);
        return root;
    }

    //方法三， 迭代法
    public TreeNode bstFromPreorder_2(int[] preorder) {
        if (preorder == null || preorder.length <= 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i =1; i<preorder.length; i++){
            TreeNode parent = stack.peek();//重要
            int val = preorder[i];
            TreeNode cur = new TreeNode(val);
            //找到父节点
            while (!stack.isEmpty() && stack.peek().val < val){
                parent = stack.pop();
            }
            if (val < parent.val)
                parent.left = cur;
            else
                parent.right = cur;
            stack.push(cur);
        }
        return root;
    }
}
