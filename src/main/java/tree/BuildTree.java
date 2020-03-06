package tree;

public class BuildTree {
	public static TreeNode createTree(Integer[] array, int index) {
		TreeNode node = null;
		if (index < array.length) {
			if(array[index] == null) {
				return null;
			}
			node = new TreeNode(array[index]);
			node.left = createTree(array, 2 * index + 1);
			node.right = createTree(array, 2 * index + 2);
		}
		return node;
	}
}
