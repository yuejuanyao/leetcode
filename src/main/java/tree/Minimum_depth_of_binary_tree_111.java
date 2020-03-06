package tree;

public class Minimum_depth_of_binary_tree_111 {
	
//	叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
//	当 root 节点左右孩子都为空时，返回 1
//	当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
//	当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
    public static int minDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.left == null && root.right == null) {
    		return 1;
    	}
    	int left = minDepth(root.left);
    	int right = minDepth(root.right);
    	if(root.left == null || root.right == null) {
    		return 	left+right+1;
    	}
    	return Math.min(left, right) + 1;
    }
    
    public static int deep_node(TreeNode node) {
    	if(node == null) {
    		return 0;
    	}
    	if(node.left == null && node.right == null) {
    		return 1;
    	}
    	int left = deep_node(node.left);
    	int right = deep_node(node.right);
    	if(node.left == null || node.right == null) {
    		return 	left+right+1;
    	}
    	return Math.min(left, right) + 1;
    }
    
    public static void main(String[] args) {
		Integer[] nodes = {3,9,20,null,null,15,7};
 		TreeNode root = BuildTree.createTree(nodes, 0);
 		System.out.println(minDepth(root));
 		System.out.println(Integer.MAX_VALUE);
	}
}
