package string;


/*
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 注意：整数顺序将表示为一个字符串。
 */

import org.junit.Test;

public class Count_and_Say_38 {


    public static String test(String str) {
        //String str_end = "";
        StringBuffer str_end = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            char now = str.charAt(i);
            int num = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (now != str.charAt(j)) {
                    break;
                }
                num++;
            }
            //System.out.println(num);
            i += num;
            str_end.append(String.valueOf(num)).append(now);
        }
        return str_end.toString();
    }

    public static String test2(int n) {
        String str = "1";
        if (n == 1) {
            return str;
        }

        for (int i = 2; i <= n; i++) {
            str = test(str);
        }
        return str;

    }

    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            char curChar = cur.charAt(0);
            int curCount = 0;
            StringBuilder nextString = new StringBuilder();
            for (char c : cur.toString().toCharArray()) {
                if (c == curChar)
                    curCount++;
                else {
                    nextString.append(curCount).append(curChar);
                    curChar = c;
                    curCount = 1;
                }
            }
            nextString.append(curCount).append(curChar);
            cur = nextString;
        }
        return cur.toString();
    }

    @Test
    public void test() {

//    	System.out.println(test2(5));
		System.out.println(countAndSay(5));
    }
}
