package math;

public class Shu_zhi_de_zheng_shu_ci_fang_lcof_16 {
    public double myPow(double x, int n) {
        //指数可能为负数，所以当x=0默认返回0
        if (x == 0)
            return 0;
        if (n < 0){
            x = -x;
            n = -n;
        }
        double res = 1;
        while (n > 0){
            if ((n & 1) == 1){
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
