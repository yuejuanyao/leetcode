package practice1;

public class Er_jin_zhi_zhong_1de_ge_shu_lcof_15 {
    public int hammingWeight(int n) {
        boolean flag = false;
        if (n < 0)
            flag = true;
        int i = 0;
        int count = 0;
        while(i < 32){
            int tmp = n & 0xffffff1;
            if ( tmp== 1)
                count++;
            n >>= 1;
            i++;
        }
        return flag ? count+1 : count;
    }
}
