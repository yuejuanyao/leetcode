package practice1;

import org.junit.Test;

public class Fei_bo_na_qi_shu_lie_lcof_m10_1 {
    public int fib(int n) {
        if ( n == 0)
            return 0;
        if (n == 1)
            return 1;
        int n_2 = 0;
        int n_1 = 1;
        int sum = 0;
        for (int i = 2; i<=n; i++){
            sum = (n_1 + n_2) % 100000007;
            n_2 = n_1;
            n_1 = sum;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(fib(2));
        System.out.println(fib(5));
        System.out.println(fib(100));
    }
}
