package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Validate_binary_tree_nodes_1361 {
    int[] leftChild, rightChild;
    boolean[] visited;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.visited = new boolean[n];
        //1.判断是否有入度是否大于1
        int[] inDegree = new int[n];
        for (int i = 0; i < leftChild.length; i++) {
            int left = leftChild[i];
            int right = rightChild[i];
            if ((left != -1 && ++inDegree[left] > 1) || (right != -1 && ++inDegree[right] > 1))
                return false;
        }
        //2.找到根节点，如果有两个入读为0的，false
        int root = -1;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0){
                if (root != -1)
                    return false;
                root = i;
            }
        }
        //3.连通性判断 1 <--- 0 <--->  2， 4 --->3
        dfs(root);
        for (boolean b : visited){
            if (!b)
                return false;
        }
        return true;
    }

    private void dfs(int root) {
        if (root == -1)
            return;
        visited[root] = true;
        dfs(leftChild[root]);
        dfs(rightChild[root]);
    }
}

