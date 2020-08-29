package math;

public class Shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_ii_lcof_56_2 {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length <= 0)
            return -1;
        int[] bits = new int[32];
        for(int num :nums){
            int index = 1;
            for(int i=0; i<32; i++){
                if((index & num) != 0)
                    bits[i]++;
                index <<= 1;
            }
        }
        int res = 0;
        for(int i = 31; i>=0; i--){
            res <<= 1;
            res += (bits[i] %3);
        }
        return res;
    }
}
