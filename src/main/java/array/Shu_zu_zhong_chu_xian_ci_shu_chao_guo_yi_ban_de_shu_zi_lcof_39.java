package array;

public class Shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi_lcof_39 {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length <=0)
            return 0;
        int res = 0;
        int vote = 0;
        for(int num : nums ){
            if(vote == 0)
                res = num;
            vote = num == res ? vote +1: vote - 1;
        }
        return res;
    }
}
