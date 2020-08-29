package practice1;

import org.junit.Test;

import java.util.Arrays;

public class Shu_zu_zhong_zhong_fu_de_shu_zi_lcof_m3 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <=1)
            return -1;
        for(int i = 0; i<nums.length; i++){
            while (nums[i] != i){ //注意一定要放到原位置，i也必须时i
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }else{
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return -1;
    }
    @Test
    public void test(){
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    }
}
