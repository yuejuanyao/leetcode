package practice1;

public class FactorialTrailingZeroes_172 {

    // 实际上是计算有多少个5，比如 10！ 中 5， 10 共有2个5 ，但是会超时
    // 5的个数其实就是有多少个5 ，25， 125， n / 5 + n / 25 + n / 125 ...
    // 写程序的话，如果直接按照上边的式子计算，分母可能会造成溢出。所以算 n / 25 的时候，我们先把 n 更新，n = n / 5，然后再计算 n / 5 即可。后边的同理
    public static int trailingZeroes(int n){
        int count = 0;
        while (n > 0){
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
    }
}
