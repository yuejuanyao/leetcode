package practice1;

public class maxSubArray {

	public static void main(String[] args) {
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		Solution1 s = new Solution1();
		System.out.println(s.maxSubArray(a));
	}
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        
        for(int i=0; i<nums.length; i++) {
        	int sum = nums[i];
        	if(sum > max) {
        		max = sum;
        	}
        	for(int j=i+1; j<nums.length; j++) {
        		sum += nums[j];
        		if(sum>max) {
        			max = sum;
        		}
        	}
        }
        return max;
    }
}

class Solution1{
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;
		for(int num : nums) {
			if(sum<0) {
				sum = num;
			}
			else {
				sum += num;
			}
			max = Math.max(sum, max);
		}
		return max;
		
	}
}