package practice1;

import java.util.ArrayList;

public class Yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof_m62 {
    public int lastRemaining(int n, int m) {
        if (n == 1)
            return n;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int curIndex = 0;
        while (n > 1) {
            curIndex = (curIndex + m - 1) % n;
            list.remove(curIndex);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining_1(int n, int m) {
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }

        return res;
    }

    public int lastRemaining_2(int n, int m) {
        return getSub(n, m);
    }

    private int getSub(int n, int m) {
        if (n == 1)
            return 0;
        int index = getSub(n - 1, m);
        // （之前的索引位置 + 移动的个数（就是m） ）% 当前数组的个数
        return (index + m) % n;
    }
}
