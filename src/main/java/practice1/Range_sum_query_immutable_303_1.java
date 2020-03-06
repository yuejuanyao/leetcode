package practice1;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Range_sum_query_immutable_303_1 {
    private int[] nums;
    private int[] sums;

    public Range_sum_query_immutable_303_1(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
            System.out.println(sums[i]);
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }

}
