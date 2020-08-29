package practice1;

import org.junit.Test;

import java.util.Arrays;

public class Zui_xiao_de_kge_shu_lcof_m40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
