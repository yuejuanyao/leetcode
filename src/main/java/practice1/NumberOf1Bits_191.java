package practice1;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class NumberOf1Bits_191 {
    public static int hammingWeight(int n) {
        new LinkedList<>();
        int count = 0;
        int test = 1;
        for(int i = 0; i<32; i++){
            if((n & test) !=0){
                count ++;
            }
            test <<= 1;
        }
        return count;
    }
    //在二进制表示中，数字 nn 中最低位的 1 总是对应 n - 1中的 0 。因此，将 n 和 n - 1 与运算总是能把 n
    // 中最低位的 1 变成 0 ，并保持其他位不变
    public static int hammingWeight_1(int n) {
        int count = 0;
        while (n != 0){
          n &= (n-1);
          count++;
        }
        Set<String > test  = new LinkedHashSet<>();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight_1(11));
    }
}
