package tree;

import org.junit.Test;

import java.util.*;

public class Validate_binary_search_tree_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return checkSubTree(root, null, null);
    }
    private boolean checkSubTree(TreeNode curNode, Integer min, Integer max){
        int curVal = curNode.val;
        if (min != null && curVal <= min)
            return false;
        if (max != null && curVal >= max)
            return false;
        if (curNode.left != null && !checkSubTree(curNode.left, min ,curVal))
            return false;
        if (curNode.right != null && !checkSubTree(curNode.right, curVal,max))
            return false;
        return true;
    }
    // 层次遍历
    public boolean isValidBST_1(TreeNode root) {
        if (root == null)
            return true;
        class NodeWithLimit{
            TreeNode node;
            Integer  low;
            Integer high;
            public NodeWithLimit(TreeNode node, Integer low, Integer high) {
                this.node = node;
                this.low = low;
                this.high = high;
            }
        }
        Queue<NodeWithLimit> queue = new LinkedList<>();
        queue.offer(new NodeWithLimit(root, null, null));
        while (!queue.isEmpty()){
            NodeWithLimit cur = queue.poll();
            if (cur.low != null && cur.node.val <= cur.low)
                return false;
            if (cur.high != null && cur.node.val >= cur.high)
                return  false;
            if (cur.node .left != null)
                queue.offer(new NodeWithLimit(root.left, cur.low, cur.node.val));
            if (cur.node.right != null)
                queue.offer(new NodeWithLimit(root.right, cur.node.val, cur.high));
        }
        return true;
    }

    // 中序遍历
    public boolean isValidBST_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double before =  - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= before)
                return false;
            before = root.val;
            root = root.right;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(Double.MAX_VALUE);
    }
}
