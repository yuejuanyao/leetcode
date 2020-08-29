package tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_right_side_view_199 {
    //广度优先
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();
        if (root == null)
            return resList;
        Pair<TreeNode, Integer> first = new Pair<>(root, 1);
        queue.add(first);
        Pair<TreeNode, Integer> pre = first;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            TreeNode curNode = cur.getKey();
            Integer curLevel = cur.getValue();
            if (!curLevel.equals(pre.getValue())) {
                resList.add(pre.getKey().val);
            }
            pre = cur;
            if (curNode.left != null)
                queue.add(new Pair<>(curNode.left, curLevel + 1));
            if (curNode.right != null)
                queue.add(new Pair<>(curNode.right, curLevel + 1));
        }
        resList.add(pre.getKey().val);
        return resList;
    }

    //深度优先
    List<Integer> resList = new ArrayList<>();

    public List<Integer> rightSideView_1(TreeNode root) {
        dfs(root, 0);
        return resList;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth == resList.size()) {
            resList.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
