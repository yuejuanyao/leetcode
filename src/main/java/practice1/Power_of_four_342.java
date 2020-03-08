package practice1;

import org.junit.Test;

public class Power_of_four_342 {
    public boolean isPowerOfFour(int num) {
        if(num <=0)
            return false;
        return Integer.toString(num,4).matches("^10*$");
    }
    public boolean isPowerOfFour_1(int num) {
        return (num & (num-1)) == 0 && num % 3 ==1;
    }
    //与2的幂区分开的一个办法是，如果是2，8，是奇数次幂，4，16是偶数次幂，所以与10101010..10与是0
    public boolean isPowerOfFour_2(int num) {
        return num>0 && (num & (num-1)) == 0 && (num & 0xaaaaaaaa) ==0;
    }
    @Test
    public void test(){

        System.out.println(isPowerOfFour_2(8));
    }
}
