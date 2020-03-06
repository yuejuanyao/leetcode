package practice1;

public class Power_of_two_231 {
    public boolean isPowerOfTwo(int n) {
        //x-1&x能够去除最右边的1
        return n>0 && ((n-1) & n) == 0;
    }
    public boolean isPowerOfTwo_1(int n) {
        return n>0 && (n &(-n))==n;
    }
}
