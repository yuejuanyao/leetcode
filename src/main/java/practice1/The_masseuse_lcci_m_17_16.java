package practice1;

public class The_masseuse_lcci_m_17_16 {
    public int massage(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        if (nums.length < 2)
            return nums[0];
        int[] curMax = new int[nums.length];
        curMax[0] = nums[0];
        curMax[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i<nums.length; i++){
            curMax[i] = Math.max(curMax[i-1], curMax[i-2] + nums[i]);
        }
        return curMax[curMax.length-1];
    }

    public int massage_1(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        if (nums.length < 2)
            return nums[0];
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i<nums.length; i++){
            int curMax = Math.max(dp0 + nums[i],dp1);
            dp0 = dp1;
            dp1 = curMax;
        }
        return dp1;
    }
}
