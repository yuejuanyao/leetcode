package practice1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Missing_number_268 {
    //方法1，排序并比较下标
    public int missingNumber(int[] nums) {
        if (nums == null)
            return -1;
        Arrays.sort(nums);
        if (nums.length==0 || nums[nums.length - 1] == nums.length - 1)
            return nums.length;
        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return -1;
    }

    //哈希表法
    public int missingNumber_1(int[] nums) {
        if (nums == null)
            return -1;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i))
                return i;
        }
        return -1;
    }

    // 位运算
    // 由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，
    // 因此我们可以通过异或运算找到缺失的数字。
    public int missingNumber_2(int[] nums) {
        if (nums == null)
            return -1;
        int mising = nums.length;
        for (int i=0; i<nums.length;i++){
            mising ^= (i ^ nums[i]);
        }
        return mising;
    }

    //数学求和法
    public int missingNumber_3(int[] nums) {
        long sum = nums.length  * (nums.length+1) /2;
        for (int x : nums)
            sum -= x;
        return (int)sum;
    }
    @Test
    public void test() {
        int[] nums = {3,0,1};
        System.out.println(nums == null);
        Assert.assertEquals(2,missingNumber_3(nums));
    }
}
