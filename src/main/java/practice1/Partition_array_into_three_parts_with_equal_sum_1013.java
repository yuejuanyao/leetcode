package practice1;

import org.junit.Test;

public class Partition_array_into_three_parts_with_equal_sum_1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3)
            return false;
        int sum = 0;
        for (int x : A) {
            sum += x;
        }
        if (sum % 3 != 0) return false;
        int part = 0;
        int part_sum = 0;
        sum /= 3;
        for (int x : A) {
            part_sum += x;
            if (part_sum == sum) {
                part += 1;
                part_sum = 0;
            }
            if(part > 2) //注意有【10，-10，10，-10，10，-10，10，-10】
                return true;
        }
        return false;
    }
    //双指针法
    public boolean canThreePartsEqualSum_1(int[] A) {
        if (A == null || A.length < 3)
            return false;
        int sum = 0;
        for (int x : A) {
            sum += x;
        }
        if (sum % 3 != 0) return false;
        int i = 0;
        int j = A.length-1;
        int sum_head = A[0], sum_end = A[A.length-1];
        sum /= 3;
        while (i<j-1){
            if (sum_head == sum && sum_end == sum){
                //System.out.println(i + " " + j);
                return true;
            }
            if (sum_head != sum){
                sum_head += A[++i];
            }
            if (sum_end != sum) {
                sum_end += A[--j];
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums = {1,-1,1,-1};
        System.out.println(canThreePartsEqualSum_1(nums));
    }
}
