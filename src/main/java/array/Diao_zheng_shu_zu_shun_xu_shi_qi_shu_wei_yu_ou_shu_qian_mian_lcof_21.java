package array;

public class Diao_zheng_shu_zu_shun_xu_shi_qi_shu_wei_yu_ou_shu_qian_mian_lcof_21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length<=1)
            return nums;
        int i = 0;
        int length = nums.length;
        int j = length-1;
        while (i < j){
            while (i < j && !isEven(nums[i]))
                i++;
            while (i < j && isEven(nums[j]))
                j--;
            if (i < j){
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = tmp;
            }
        }
        return nums;
    }
    boolean isEven(int num){
        return (num & 1) == 0;
    }
}
