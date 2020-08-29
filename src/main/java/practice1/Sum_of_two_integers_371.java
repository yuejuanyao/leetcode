package practice1;

import org.junit.Test;

public class Sum_of_two_integers_371 {
    public int getSum(int a, int b) {
        int carry = (a & b)<<1;
        int sum = a ^ b;
        while (carry != 0){
            int tmp = sum ^ carry;
            carry = (sum & carry)<<1;
            sum = tmp;
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(getSum(2,-6));
    }
}
