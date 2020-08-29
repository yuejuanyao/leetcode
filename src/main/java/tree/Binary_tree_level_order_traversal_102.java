package tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_level_order_traversal_102 {
    //层次遍历 方法1
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        if (root == null)
            return res;
        List<Integer> list = new LinkedList<>();
        queue.add(new Pair<>(root,1));
        int tmpDepth = 1;
        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> cur = queue.poll();
            TreeNode curNode = cur.getKey();
            Integer curDepth = cur.getValue();
            if (curDepth != tmpDepth){
                res.add(list);
                tmpDepth = curDepth;
                list = new LinkedList<>();
            }
            list.add(curNode.val);
            if (curNode.left != null)
                queue.add(new Pair<>(curNode.left,curDepth+1));
            if (curNode.right != null)
                queue.add(new Pair<>(curNode.right,curDepth+1));
        }
        res.add(list);
        return res;
    }

    //层次遍历 方法2
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int levelSize = queue.size();
            TreeNode cur;
            for (int i = 0; i< levelSize; i++){
                cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            res.add(list);
        }
        return res;
    }
    //递归
    List<List<Integer>> levels = new LinkedList<>();
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        if (root == null)
            return levels;
        helper(root,0);
        return levels;
    }

    private void helper(TreeNode root, int depth) {
        if (levels.size() == depth){
            levels.add(new LinkedList<>());
        }
        levels.get(depth).add(root.val);
        if (root.left != null)
            helper(root.left, depth+1);
        if (root.right != null)
            helper(root.right, depth+1);
    }
}
