package tree;

public class TreeNode {
	Integer val;
	TreeNode left;
	TreeNode right;

	TreeNode(Integer x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	
}