package practice1;

import org.junit.Test;

public class Valid_perfect_square_367 {
    //二分查找法
    public boolean isPerfectSquare(int num) {
        if (num <= 0)
            return false;
        if (num == 1)
            return true;
        long i = 1;
        long j = num / 2;
        while (i <= j) {
            long mid = (i + (j - i) / 2);
            long result = mid * mid;
            if (result > num) {
                j = mid - 1;
            }else if (result < num) {
                i = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare_1(int num) {
        if (num <= 0)
            return false;
        if (num == 1)
            return true;
        int i = 1;
        int j = num / 2;
        while (i <= j) {
            int mid = (i + (j - i) / 2);
            int result = num / mid;
            if (result == mid && num % mid ==0) {
                return true;
            }else if (result < mid) {
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return false;
    }
    /*
    1 = 1;
    4 = 1 + 3;
    9 = 1 + 3 + 5;
    16 = 1 + 3 + 5 + 7;
     */
    public boolean isPerfectSquare_2(int num) {
        int i = 1;
        while (num >0){
            num -= i;
            i +=2;
        }
        return num == 0;
    }
    @Test
    public void test(){
        System.out.println(isPerfectSquare_2(808201));
    }
}
