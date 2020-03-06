package practice1;

import org.junit.Test;

public class Add_digits_258 {
    public int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    //119 = 1*100+1+10+9 = 1*99 + 1*9 + 1+1+9 = 1*99 + 1*9 + 1*10+1=1*99 + 1*9 + 1*9 +1 +1
    public int addDigits_1(int num) {
        //return (num - 1) % 9 + 1;
        if (num%9==0&&num!=0)
            num=9;
        else
            num%=9;

        return num;
    }
    @Test
    public  void test(){
        System.out.println(addDigits(1298));
    }
}
