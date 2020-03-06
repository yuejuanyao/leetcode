package tree;

public class Path_sum_112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
        	return false;
        }
        sum -= root.val;
        if(root.left == null && root.right == null) {
        	return sum==0;
        }
    	return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
    
    public static void main(String[] args) {
    	Integer[] nodes = {5,4,8,11,null,13,4,7,2,null,null,null,1};
 		TreeNode root = BuildTree.createTree(nodes, 0);
 		System.out.println(hasPathSum(root, 23));
	}
}

