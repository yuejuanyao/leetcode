package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Same_tree {

	public TreeNode createTree(Integer[] array, int index) {
		TreeNode node = null;
		if (index < array.length) {
			node = new TreeNode(array[index]);
			node.left = createTree(array, 2 * index + 1);
			node.right = createTree(array, 2 * index + 2);
		}
		return node;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		queue1.offer(p);
		queue2.offer(q);
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if (!theSameNode(node1, node2))
				return false;
			
			if(node1 != null && node2 != null) {
				queue1.offer(node1.left);
				queue2.offer(node2.left);
				queue1.offer(node1.right);
				queue2.offer(node2.right);
			}

//			if (node1 != null && node2 != null) {
//				if (!theSameNode(node1.left, node2.left))
//					return false;
//				if (node1.left != null) {
//					queue1.offer(node1.left);
//					queue2.offer(node2.left);
//				}
//
//				if (!theSameNode(node1.right, node2.right))
//					return false;
//				if (node1.right != null) {
//					queue1.offer(node1.right);
//					queue2.offer(node2.right);
//				}
//			}
		}
		return true;
	}

	private boolean theSameNode(TreeNode p, TreeNode q) {
		if ((p == null && q == null)) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return true;
	}

	@Test
	public void test() {
		
		Queue<Integer> queue1 = new LinkedList<Integer>();
		queue1.offer(2);
		queue1.offer(null);
		queue1.poll();
		queue1.poll();
		System.out.println(queue1.isEmpty());
		System.out.println(queue1.poll());
		System.out.println(queue1.size());
		Integer[] a = { 1, 3, 4, null, 5};
		Integer[] b = { 1, 3, 4, null};
		TreeNode p = createTree(a, 0);
		TreeNode q = createTree(b, 0);
		System.out.println(isSameTree(p, q));
	}

}
