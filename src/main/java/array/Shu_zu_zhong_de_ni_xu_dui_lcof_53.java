package array;

public class Shu_zu_zhong_de_ni_xu_dui_lcof_53 {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length<=0)
            return 0;
        return subReverse(0, nums.length-1);
    }

    private int subReverse(int i, int i1) {

    }
}
