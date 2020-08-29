package practice1;

import org.junit.Test;

public class Qing_wa_tiao_tai_jie_wen_ti_lcof_m10_ii {

    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;   
    }
    @Test
    public void test(){
        System.out.println(numWays(7));
    }
}
