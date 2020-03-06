package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DuiChenErCharShu {

	public boolean isSymmetric(TreeNode root) {
		
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		return (root1.val == root2.val) && isMirror(root1.right, root2.left)
		        && isMirror(root1.left, root2.right) ;
	}
	
	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode node1 = q.poll();
			TreeNode node2 = q.poll();
			if(node1 == null && node2 == null) continue;
			if(node1 == null || node2 == null) return false;
			if(node1.val != node2.val) return false;
			
			q.add(node1.left);
			q.add(node2.right);
			q.add(node1.right);
			q.add(node2.left);
		}
		
		return true;
	}
	
	

	public void test() {
		Integer[] a = {1,2,2,3,null,4,3};
		TreeNode root = BuildTree.createTree(a, 0);
		System.out.println(isSymmetric(root));
		System.out.println(isSymmetric2(root));
	}
}
