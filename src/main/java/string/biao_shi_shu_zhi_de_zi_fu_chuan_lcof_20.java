package string;

import org.junit.Test;

public class biao_shi_shu_zhi_de_zi_fu_chuan_lcof_20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() <= 0)
            return false;
        s = s.trim();
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasnum = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasnum = true;
            } else if (c == '.') {
                if (hasPoint)
                    return false;
                hasPoint = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE || !hasnum)
                    return false;
                hasPoint = true;
                hasE = true;
                hasnum = false;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } else
                return false;
        }
        return hasnum;
    }

    int i = 0;

    public boolean isNumber_1(String s) {
        if (s == null || s.length() <= 0)
            return false;
        s = s.trim();
        int length = s.length();
        boolean A = scanIntegerWithSign(s);
        boolean B = false;
        boolean C = false;
        if (i < length && s.charAt(i) == '.') {
            i++;
            B = scanUnsignedInteger(s);
        }

        if (i < length && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            C = scanIntegerWithSign(s);
            if (!C)
                return false;
        }
        return i == length && (A || B);
    }

    private boolean scanIntegerWithSign(String s) {
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            i++;
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s) {
        int start = i;
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
            i++;
        return start < i;
    }

    @Test
    public void test() {
        System.out.printf(String.valueOf(isNumber_1("e9")));
    }
}
