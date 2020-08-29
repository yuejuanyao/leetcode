package tree;

import java.util.HashMap;
import java.util.Map;

public class Zhong_jian_er_cha_shu_lcof_m7 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length<=0)
            return null;
        for (int i = 0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildSubTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
    }

    private TreeNode buildSubTree(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (pre_end - pre_start < 0 || in_end - in_start < 0)
            return null;

        int root_index = map.get(preorder[pre_start]);
        int left_length = root_index - in_start;
        int right_length = in_end - root_index;
        TreeNode left = buildSubTree(preorder, pre_start+1, pre_start+left_length,inorder,in_start,root_index-1);
        TreeNode right = buildSubTree(preorder, pre_start+left_length+1, pre_end, inorder, root_index+1, in_end);
        TreeNode root = new TreeNode(preorder[pre_start]);
        root.left = left;
        root.right = right;
        return root;
    }
}
