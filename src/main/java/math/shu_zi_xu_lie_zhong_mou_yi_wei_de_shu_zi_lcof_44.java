package math;

public class shu_zi_xu_lie_zhong_mou_yi_wei_de_shu_zi_lcof_44 {
    public int findNthDigit(int n) {
        if (n == 0)
            return 0;
        int digit = 1;
        int start = 1;
        int counts = 9;
        //确定第n个char是第几位数；设是5位数，在边判断时就便删除前面的位数
        while (n > counts) {
            n -= counts;
            digit++;
            start *= 10;
            counts = digit * start * 9;
        }
        //判断是10000-99999中的那个数字，假设是19999
        int num = start + (n - 1) / digit;
        //判断是第几位
        return String.valueOf(num).charAt((n - 1) % digit) - '0';
    }


}
