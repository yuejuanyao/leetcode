package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_level_order_traversal_ii {
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root ==null) {
			return res;
		}
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> level = new LinkedList<Integer>();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if(node != null) {
					level.add(node.val);
					if(node.left!=null) {
						queue.add(node.left);
					}
					if(node.right!=null) {
						queue.add(node.right);
					}
				}
			}
			res.add(0, level);
			
		}
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		Integer[] nodes = {};
 		TreeNode root = BuildTree.createTree(nodes, 0);
 		System.out.println(root);
 		levelOrderBottom(root);
	}

}
