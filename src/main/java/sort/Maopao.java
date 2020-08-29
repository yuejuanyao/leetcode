package sort;

import org.junit.Test;

public class Maopao {
    public int[] maopao(int[] nums){
        if (nums == null)
            return null;

        for (int time = 0; time < nums.length-1; time++){
            for (int cur = 0; cur<nums.length-time-1; cur++){
                if (nums[cur] > nums[cur+1]){
                    int tmp = nums[cur];
                    nums[cur] = nums[cur+1];
                    nums[cur+1] = tmp;
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums = {2,6, 9, 3, 5, 7,10, 8, 3, 4};
        maopao(nums);
        for (int x : nums)
            System.out.print(x + ",");
    }
}
