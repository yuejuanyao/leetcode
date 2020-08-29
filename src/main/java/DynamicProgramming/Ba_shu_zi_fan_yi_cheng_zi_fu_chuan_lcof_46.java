package DynamicProgramming;

public class Ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof_46 {
    public int translateNum(int num) {
        if (num < 0)
            return 0;
        String s = String.valueOf(num);
        int p = 0; //f(-1)
        int q = 1; //f(0)
        int r = 1; //f(1);
        for (int i = 2; i <= s.length(); i++) {
            p = q;
            q = r;
            String cur = s.substring(i - 1, i + 1);
            if (cur.compareTo("10") >= 0 && cur.compareTo("26") <= 0)
                r = p + q;
            else
                r= q;
        }
        return r;
    }

}
