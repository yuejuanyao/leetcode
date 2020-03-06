package tree;

public class balanced_binary_tree_110 {
	
	//第一种
    public static boolean isBalanced(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	if(Math.abs(count(root.left)-count(root.right))>1) {
    		return false;
    	}
    	
    	return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public static int count(TreeNode node) {
    	
    	if(node==null) {
    		return 0;
    	}
    	int left = count(node.right) + 1;
    	int right = count(node.left) + 1;
    	return Math.max(left, right);
    }
    
    //第二种
    public static boolean isBalanced_2(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
        
    	return count_2(root)!=-1;
    }
    
    public static int count_2(TreeNode node) {
    	
    	if(node==null) {
    		return 0;
    	}
    	int left = count_2(node.right);
    	int right = count_2(node.left);
    	if(left==-1 || right == -1 || Math.abs(left-right)>1)
    		return -1;
    	return Math.max(left, right) + 1;
    }
    
    
    public static void main(String[] args) {
		Integer[] nodes = {1,2,2,3,null,null,3,4,null,null,4};
 		TreeNode root = BuildTree.createTree(nodes, 0);
 		System.out.println(isBalanced_2(root));
	}

}
