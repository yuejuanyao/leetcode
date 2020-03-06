package practice1;

import org.junit.Test;

public class Move_zeroes_283 {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
        for(int i=0,j=0; j<nums.length; j++){
            if(nums[j]!=0){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
            }
        }
    }



    @Test
    public void test(){
//        int[] nums = {0,1,2,0,3,4,5};
//        moveZeroes(nums);
    }
}
