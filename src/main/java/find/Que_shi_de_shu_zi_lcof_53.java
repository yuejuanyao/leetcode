package find;

import org.junit.Test;

public class Que_shi_de_shu_zi_lcof_53 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length<=0)
             return -1;
        if(nums[0] != 0)
            return 0;
        int length = nums.length;
        if(nums[length-1] != length)
            return length;
        int start =0;
        int end = length-1;
        while(start<end){
            int mid = start + (end -start)/2;
            if (nums[mid] == mid){
                start = mid + 1;
            }
            else
                end = mid;

        }
        return start;
    }

    @Test
    public void test(){

        System.out.println(missingNumber(new int[]{0,1,3}));
    }
}
