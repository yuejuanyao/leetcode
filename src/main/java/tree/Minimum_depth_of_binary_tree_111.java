package tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Minimum_depth_of_binary_tree_111 {
	//递归
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
	//bfs
    public static int minDepth_1(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        TreeNode curNode = root;
        int depth = 1;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            curNode = cur.getKey();
            depth = cur.getValue();
            if (curNode.left == null && curNode.right == null)
                return depth;
            if (curNode.left != null)
                queue.add(new Pair<>(curNode.left, depth + 1));
            if (curNode.right != null)
                queue.add(new Pair<>(curNode.right, depth + 1));
        }
        return depth;
    }

	//dfs
	public static int minDepth_2(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> stackNode = new Stack<>();
		Stack<Integer> stackDepth = new Stack<>();
		int curDep = 0;
		Integer minDepth = null;
		while (root != null || !stackNode.isEmpty()){
			while (root != null){
				curDep += 1;
				stackNode.push(root);
				stackDepth.push(curDep);
				root = root.left;
			}
			if (!stackNode.isEmpty()){
				root = stackNode.pop();
				curDep = stackDepth.pop();
				if (root.left == null && root.right == null){
					minDepth = minDepth == null ? curDep : Math.min(minDepth,curDep);
				}
				root = root.right;
			}
		}
		return minDepth;
	}

    public static void main(String[] args) {
        Integer[] nodes = {3, 9, 20, null, null, 15, 7};
        TreeNode root = BuildTree.createTree(nodes, 0);
        System.out.println(minDepth(root));
        System.out.println(Integer.MAX_VALUE);
    }
}
