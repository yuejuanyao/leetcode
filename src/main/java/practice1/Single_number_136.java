package practice1;

import java.util.HashMap;
import java.util.Map;

public class Single_number_136 {

	public static int singleNumber(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;
		int single = -1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer number = map.get(nums[i]);
			map.put(nums[i], number == null ? 1 : number + 1);
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				single = key;
				break;
			}
		}
		return single;

	}
	
	public static int singleNumber_1(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;
		int res = nums[0];
		for(int i=1; i<nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1};
		System.out.println(singleNumber_1(nums));

	}

}
