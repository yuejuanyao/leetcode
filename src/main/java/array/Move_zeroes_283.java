package array;

import org.junit.Test;

public class Move_zeroes_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
            }
        }
    }

    public void moveZeroes_1(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] == 0 ){
                int j ;
                for (j= i+1; j<nums.length; j++){
                    if (nums[j] != 0){
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
                if (j == nums.length-1)
                    return;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {0,1,2,3,5,0,7,0,0,0};
        moveZeroes_1(nums);
        for (int x : nums){
            System.out.print(x + ",");
        }
    }
}
