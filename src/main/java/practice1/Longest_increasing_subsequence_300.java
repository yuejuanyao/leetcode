package practice1;

public class Longest_increasing_subsequence_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length<1)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max_length = dp[0];
        for (int i = 1; i < nums.length;i++){
            dp[i] = 1;
            for (int j = 0; j<i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max_length = Math.max(max_length,dp[i]);
        }
        return max_length;
    }
}
