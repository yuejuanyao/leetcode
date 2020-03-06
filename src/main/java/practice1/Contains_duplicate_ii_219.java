package practice1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contains_duplicate_ii_219 {
    //哈希表，用map方法
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k < 0)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else {
                int dif = Math.abs(map.get(nums[i])-i);
                if(dif<=k)
                    return true;
                else
                    map.replace(nums[i],i);
            }
        }
        return false;
    }

    //哈希表，用set方法
    public boolean containsNearbyDuplicate_1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
