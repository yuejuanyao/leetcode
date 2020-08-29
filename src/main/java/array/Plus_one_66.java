package array;

import java.util.Arrays;

public class Plus_one_66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length<=0)
            return new int[0];
        for (int i = digits.length-1; i>=0; i--){
            digits[i] ++;
            if (digits[i] == 10){
                digits[i] = 0;
            }else {
                return digits;
            }
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        System.arraycopy(digits,0,res,1,digits.length);
        return res;
    }

//    public int[] plusOne(int[] digits) {
//
//    }
}
