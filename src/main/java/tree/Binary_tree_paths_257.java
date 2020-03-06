package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_paths_257 {
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        getString(root,"");
        return list;
    }

    private void getString(TreeNode root, String s) {
        if(root == null){
            return;
        }
        s = s + root.val;
        if (root.left == null && root.right == null){
            list.add(s);
            return;
        }
        s += "->";
        getString(root.left,s);
        getString(root.right,s);
    }

    //队列实现迭代
    public List<String> binaryTreePaths_1(TreeNode root) {
        if(root == null)
            return list;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<String > q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(String.valueOf(root.val));
        while (!q1.isEmpty()){
            TreeNode node = q1.remove();
            String s = q2.remove();
            if(node.left == null && node.right == null){
                list.add(s);
            }
            if(node.left != null){
                q1.offer(node.left);
                q2.offer(s+"->"+node.left.val);
            }
            if(node.right != null){
                q1.offer(node.right);
                q2.offer(s+"->"+node.right.val);
            }
        }
        return list;
    }

    @Test
    public void test(){
        Integer[] nums = {1,2,3,null,5,6,7};
        TreeNode root = BuildTree.createTree(nums,0);
        List<String> list = binaryTreePaths_1(root);
        for (String s : list){
            System.out.println(s);
        }
    }
}
