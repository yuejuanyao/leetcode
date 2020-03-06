package practice1;

public class TableSizeFor {
    /**
     * 小于0的数字最后都会变成-1；
     * 大于0的数字会求出大于该数字的最小2的幂；
     * 因为右移之后或运算，把目前最高位的后面都变成了1，然后+1
     *
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (int)Math.pow(2,30)) ? (int)Math.pow(2,30) : n + 1;
    }
}
