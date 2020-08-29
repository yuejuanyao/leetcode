package array;

import org.omg.CORBA.Object;

import java.util.*;

public class Intersection_of_two_arrays_ii_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0)
            return new int[0];
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int x : nums1) {
            if (!m1.containsKey(x)) {
                m1.put(x, 1);
            } else {
                m1.replace(x, m1.get(x) + 1);
            }
        }
        int index = 0;
        for (int x : nums2) {
            if (m1.containsKey(x)) {
                if (m1.get(x) > 0) {
                    res[index++] = x;
                    m1.replace(x, m1.get(x) - 1);
                }
            }
        }
        return Arrays.copyOf(res, index);
    }

    public int[] intersect_1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int index = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                res[index++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(res, index);
    }

    public int[] intersect_2(int[] nums1, int[] nums2) {
        return new int[0];
    }

    public static void main(String[] args) {

    }
}