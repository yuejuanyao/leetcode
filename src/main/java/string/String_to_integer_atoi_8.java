package string;

import org.junit.Test;

import java.util.List;

public class String_to_integer_atoi_8 {
    /*
    str.trim(); //去掉首尾空格
    str.replace(" ",""); //去除所有空格，包括首尾、中间
    str.replaceAll(" ", ""); //去掉所有空格，包括首尾、中间
    str.replaceAll(" +","");  //去掉所有空格，包括首尾、中间
    str.replaceAll("\\s*", ""); //可以替换大部分空白字符， 不限于空格 ；
     */
    public int myAtoi(String str) {
        if (str == null || str.length()<=0)
            return 0;
        // 去除空格
        String sNoSpace = str.replaceAll(" ","");
        if(sNoSpace.length() <= 0)
            return 0;
        boolean isfalse = false;
        //判断开头
        char begin = sNoSpace.charAt(0);
        if (begin == '-')
            isfalse = true;
        else if (begin == '+')
            isfalse = false;
        else if (begin < '0' || begin > '9')
            return 0;
        //运算
        int res = 0;
        int index = 0;
        if (begin == '-' || begin =='+')
            index ++;
        while (index< sNoSpace.length()){
            char c = sNoSpace.charAt(index);
            if (c >='0' && c<='9'){
                if (isfalse && (res > 214748364 || (res ==214748364 && c-'0'>8) )){
                    return Integer.MIN_VALUE;
                }
                if (!isfalse && (res > 214748364 || (res ==214748364 && c-'0'>7) ) ){
                    return Integer.MAX_VALUE;
                }
                res = res * 10 + c -'0';
            }else {
                return isfalse ? -res : res;
            }
            index++;
        }
        return isfalse ? -res : res;
    }




    @Test
    public void test(){
        String s = "  -0012a42";

        System.out.println(myAtoi(s));
    }
}
