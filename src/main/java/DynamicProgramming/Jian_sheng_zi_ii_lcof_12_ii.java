package DynamicProgramming;

import org.junit.Test;

public class Jian_sheng_zi_ii_lcof_12_ii {
    int mod = (int)1e9+7;
    public int cuttingRope(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timeofThree = 0;
        timeofThree = n / 3;
        if (n - timeofThree * 3 == 1)
            timeofThree -= 1;
        int timeofTwo = (n - timeofThree * 3)/2;
        return (int)(pow(3, timeofThree) * pow(2, timeofTwo) % mod);
    }

    private long pow(long base, int times) {
        long res = 1;
        while (times > 0){
            if ((times & 1) == 1){
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            times >>= 1;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(cuttingRope(999));
    }
}
