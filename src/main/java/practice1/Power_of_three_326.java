package practice1;

import org.junit.Test;

public class Power_of_three_326 {
    public boolean isPowerOfThree(int n) {
        if(n<1)
            return false;
        while (n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }

    //基准转换法如 10 = 2 ，100 = 41
    public boolean isPowerOfThree_1(int n) {
        return Integer.toString(n,3).matches("^10*$");
    }

//    public boolean isPowerOfThree_2(int n) {
//        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
//    }

    @Test
    public void test(){
        System.out.println(isPowerOfThree_1(3));
        System.out.println(Math.log10(243) / Math.log10(3));
    }
}
