package practice1;

import org.junit.Test;

public class Guess_number_higher_or_lower_374 {
    public int guessNumber(int n) {
        int i = 1;
        int j = n;
        while (i<=j){
            int mid = i+(j-i)/2;
            int result_res = guess(mid);
            if (result_res == -1){
                j = mid -1;
            }else if (result_res == 1){
                i = mid + 1;
            }else {
                return mid;
            }
        }
        return j;
    }

    private int guess(int i) {
        return Integer.compare(i, 6);
    }
    @Test
    public void test(){
        System.out.println(guessNumber(10));
    }
}
