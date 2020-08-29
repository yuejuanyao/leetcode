package string;

import org.junit.Test;

public class Reverese_Integer_7 {

    public int reverse(int x) {
        int res = 0;
        int maxRemoveLast = Integer.MAX_VALUE/10;
        int maxLast = Integer.MAX_VALUE%10;
        int minRemoveLast = Integer.MIN_VALUE/10;
        int minLast = Integer.MIN_VALUE%10;
        while(x != 0){
            int next = x % 10;
            if(res > 0 && (res > maxRemoveLast || res == maxRemoveLast && next > maxLast))
                return Integer.MAX_VALUE;
            if(res < 0 && (res < minRemoveLast  || res == minRemoveLast && next < minLast))
                return Integer.MIN_VALUE;
            res  += res * 10 ;
            x /= 10;
        }
        return res;
    }

    @Test
    public void test(){
        int x = 321;
        System.out.println(reverse(x));
    }
}
