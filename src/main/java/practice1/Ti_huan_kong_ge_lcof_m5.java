package practice1;

import org.junit.Test;

public class Ti_huan_kong_ge_lcof_m5 {
    public String replaceSpace(String s) {
        String s_ = s.replace(" ","%20");
        return s_;
    }

    public String replaceSpace_1(String s) {
        StringBuilder s_replaced = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c != ' '){
                s_replaced.append(c);
            }else {
                s_replaced.append("%20");
            }
        }
        return s_replaced.toString();
    }

    public String replaceSpace_2(String s) {
        int space_length = 0;
        for (char c  : s.toCharArray()){
            if (c == ' ')
                space_length ++;
        }
        char[] chars = new char[s.length()+space_length * 2];
        int index = 0;
        for (char c  : s.toCharArray()){
            if (c == ' '){
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            }else {
                chars[index++] = c;
            }
        }
        return new String(chars);
    }
    @Test
    public void test(){
        String s = "We are happy.";
        System.out.println(replaceSpace_2(s));
    }
}
