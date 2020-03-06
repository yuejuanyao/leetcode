package practice1;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Range_sum_query_immutable_303 {

    private int[] nums;
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public Range_sum_query_immutable_303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        Pair<Integer, Integer> pair = new Pair<>(i, j);
        if (map.containsKey(pair)) {
            return map.get(pair);
        } else {
            for (int index = i; index <= j; index++) {
                sum += nums[index];
            }
            map.put(pair, sum);
        }
        return sum;
    }
}
