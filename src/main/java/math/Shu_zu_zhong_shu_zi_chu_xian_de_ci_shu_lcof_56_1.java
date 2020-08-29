package math;

public class Shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof_56_1 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length<=1)
            return null;
        int tmp = 0; //第一步获取两个数的异或值，因为是异或，所以当某一位为 1，说明这两个数再次位不同
        for (int num : nums) {
            tmp ^= num;
        }
        int notZero = 1; //查找 为1的位置
        while((tmp & notZero) == 0)
            notZero <<= 1;
        int x = 0;
        int y = 0; //根据这一位将数组分成两部分，进行异或
        for (int num : nums) {
            if ((num & notZero) == 0)
                x ^= num;
            else
                y ^= num;
        }
        return new int[]{x,y};
    }
}
