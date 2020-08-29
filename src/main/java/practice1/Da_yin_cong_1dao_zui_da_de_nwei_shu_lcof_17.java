package practice1;

import org.junit.Test;

public class Da_yin_cong_1dao_zui_da_de_nwei_shu_lcof_17 {
    public int[] printNumbers(int n) {
        int length = power(10,n)-1;
        int[] res = new int[length];
        for (int i = 0; i<length; i++){
            res[i] = i+1;
        }
        return res;
    }

    private int power(int base, int n) {
        int res = 1;
        while (n > 0){
            if (n % 2 == 1)
                res *= base;
            n /= 2;
            base *= base;
        }
        return res;
    }

    public void printNumbers_1(int n) {
        StringBuilder num = new StringBuilder("0");
        int index = 0;
        while (index < n){
            int carry = 0;
            //加 1 操作
            for (int i = 0; i<num.length() ;i++){
                char c= num.charAt(i);
                // 加 1 之前判断是否为末尾的数字
                c = i == 0? (char)(c + 1) : (char)(c + carry);
                //判断是否产生的进位
                if (c > '9'){
                    carry = 1;
                    c = c = (char)(c - 10);
                }else { //没有进位记得清除上一次的进位符号
                    carry = 0;
                }
                num.setCharAt(i,c);
            }
            //该次加 1 操作，判断最后一位有没有产生进位
            if (carry == 1 ){
                // 如果产生进位，但是当前的位数已经到了n位，那么就直接break，不再进行下面操作
                if (num.length() == n){
                    break;
                }else { //如果没有到n位，那么位字符串追加一位，长度增加1位
                    num.append('1');
                    index++;
                }
            }
            //答应字符，注意是反转打印的
            stingNumPrint(num);
        }
    }

    public void printNumbers_2(int n) {
        StringBuilder num = new StringBuilder("0");
        int index = 0;
        // index 为目前数字的位数，当有进位时 +1
        while (index < n){
            int carry = 0;
            //加 1 操作
            boolean hasCarry = false;
            for (int i = 0; i<num.length(); i++){
                char c = (char)(num.charAt(i) + 1);
                if (c > '9'){
                    hasCarry = true;
                    num.setCharAt(i,'0');
                }else {
                    num.setCharAt(i,c);
                    hasCarry = false;
                    break;
                }
            }
            //该次加 1 操作，判断最后一位有没有产生进位
            if (hasCarry){
                // 如果产生进位，但是当前的位数已经到了n位，那么就直接break，不再进行下面操作
                if (num.length() == n){
                    break;
                }else { //如果没有到n位，那么位字符串追加一位，长度增加1位
                    num.append('1');
                    index++;
                }
            }
            //答应字符，注意是反转打印的
            stingNumPrint(num);
        }
    }

    private StringBuilder plusOne(StringBuilder s){
        for (int i = 0;i<s.length(); i++){
            char c = (char)(s.charAt(i) + 1);
            if (c > '9'){
                s.setCharAt(i,'0');
            }else {
                s.setCharAt(i,c);
                return s;
            }
        }
        return s.append('1');
    }

    private void stingNumPrint(StringBuilder num) {
        for (int i = num.length() -1 ; i >=0 ; i--){
            System.out.print(num.charAt(i));
        }
        System.out.println();
    }

    @Test
    public void test(){
        //printNumbers_2(3);
        System.out.println(plusOne(new StringBuilder("99898")));
    }
}
