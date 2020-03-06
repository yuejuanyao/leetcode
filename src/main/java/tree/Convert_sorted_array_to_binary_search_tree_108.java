package tree;

public class Convert_sorted_array_to_binary_search_tree_108 {

	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums==null || nums.length<=0) {
			return null;
		}
		int start = 0;
		int end = nums.length - 1;
		TreeNode root = curr(nums, start, end);
		return root;
	}
	
	public static TreeNode curr(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode mid_node = new TreeNode(nums[mid]);
		mid_node.left = curr(nums, start, mid-1);
		mid_node.right = curr(nums, mid+1, end);
		return mid_node;
	}

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		System.out.println(sortedArrayToBST(nums));
	}

}
