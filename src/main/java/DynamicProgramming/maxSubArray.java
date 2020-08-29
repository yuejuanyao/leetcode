package DynamicProgramming;

public class maxSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum > max) {
                max = sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray_2(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
    //动态规划
	public int maxSubArray_4(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;
    	int tmp = nums[0];
    	int res = tmp;
    	for (int i = 1; i<nums.length; i++){
    		tmp = Math.max(tmp + nums[i], nums[i]);
    		res = Math.max(res, tmp);
		}
    	return res;
	}

	//分治法
	public int maxSubArray_3(int[] nums) {
    	if (nums == null || nums.length <= 0)
    		return 0;
    	return helper(nums, 0, nums.length-1);
	}

	private int helper(int[] nums, int left, int right) {
    	if (left == right)
    		return nums[left];
		int mid = (left + right) /2;
		int leftMax = helper(nums, left, mid);
		int rightMax = helper(nums, mid + 1, right);
		int crossMax = cross(nums, left, right, mid);
		return Math.max(Math.max(leftMax,rightMax), crossMax);
	}

	private int cross(int[] nums, int left, int right, int mid) {
    	if (left == right)
    		return nums[left];
    	int curLeftMax = Integer.MIN_VALUE;
    	int sumLeft = 0;
    	for (int i=mid; i>= left; i--){
			sumLeft += nums[i];
			curLeftMax = Math.max(sumLeft, curLeftMax);
		}
		int curRightMax = Integer.MIN_VALUE;
		int sumRight = 0;
		for (int i=mid+1; i<= right; i++){
			sumRight += nums[i];
			curRightMax = Math.max(sumRight, curRightMax);
		}
		return curLeftMax + curRightMax;
	}
}
