package tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Maximum_depth_of_binary_tree_104 {
    //bfs
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        int curDepth = 1;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            TreeNode curNode = cur.getKey();
            curDepth = cur.getValue();
            if (curNode.left != null)
                queue.offer(new Pair<>(curNode.left, curDepth+1));
            if (curNode.right != null)
                queue.offer(new Pair<>(curNode.right, curDepth+1));
        }
        return curDepth;
    }
    // dfs 递归
    public int maxDepth_1(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth_1(root.left);
        int right = maxDepth_1(root.right);
        return Math.max(left,right) + 1;
    }
    // dfs 迭代
    public int maxDepth_2(TreeNode root) {
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackDepth = new Stack<>();
        int curDepth = 0;
        int maxDepth = curDepth;
        while (root != null || !stackNode.isEmpty()){
            while (root != null){
                curDepth += 1;
                stackNode.push(root);
                stackDepth.push(curDepth);
                root = root.left;
            }
            root = stackNode.pop();
            curDepth = stackDepth.pop();
            maxDepth = Math.max(curDepth, maxDepth);
            root = root.right;
        }
        return maxDepth;
    }
}
