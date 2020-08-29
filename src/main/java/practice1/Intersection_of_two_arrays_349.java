package practice1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection_of_two_arrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1== null || nums1.length<=0 || nums2 == null || nums2.length<=0)
            return new int[0];
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        for (int x : nums1)
            n1.add(x);
        int index = 0;
        for (int x : nums2){
            if (!n2.contains(x)){
                n2.add(x);
                if (n1.contains(x))
                    res[index++] = x;
            }
        }
        //或者直接用 n1.retainAll(n2);
        return Arrays.copyOf(res,index);
    }
}
