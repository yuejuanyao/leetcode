package practice1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    //哈希表法
    public static int majorityElement(int[] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i = 0;
        while (i<nums.length){
            if(map.containsKey(nums[i])){
                Integer count = map.get(nums[i]) + 1;
                if(nums.length/2 < count){
                    return nums[i];
                }
                map.replace(nums[i], count);
            }else {
                map.put(nums[i],1);
            }
            i++;
        }
        return 0;
    }

    //排序法
    public static int majorityElement_1(int[] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //投票法
    public static int majorityElement_2(int[] nums) {
        int count = 0;
        if(nums==null || nums.length<=0){
            return 0;
        }
        Integer tmp = null;
        for(int num : nums){
            if(count == 0) {
                tmp = num;
            }
            count += (tmp == num) ? 1 : -1;
        }
        return tmp;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,3};
        int a = majorityElement_2(nums);
        System.out.println(a);
    }
}
