package practice1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class Contains_duplicate_217 {
    // 哈希表法
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(!set.contains(x)){
               set.add(x);
            }else {
                return true;
            }
        }
        return false;
    }

    // 排序法
    public boolean containsDuplicate_1(int[] nums) {
        if(nums == null)
            return false;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1;i++){
            if (nums[i] == nums[i+1])
                return true;
        }
        return false;
    }

    @Test
    public void test(){
        Contains_duplicate_217 test = new Contains_duplicate_217();
        int[] nums_true = {1,2,3,1};
        int[] nums_false = null;
        System.out.println(nums_false == null);
        assertTrue(test.containsDuplicate_1(nums_true));
        assertFalse(test.containsDuplicate_1(nums_false));
    }
}


