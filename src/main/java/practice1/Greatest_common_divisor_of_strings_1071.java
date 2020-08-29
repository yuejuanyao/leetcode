package practice1;

import org.junit.Test;

public class Greatest_common_divisor_of_strings_1071 {
    //枚举法
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < 1 || str2.length() < 1)
            return "";
        int max_length = Math.min(str1.length(), str2.length());
        int len_1 = str1.length();
        int len_2 = str2.length();
        for (int i = max_length; i > 0; i--) {
            if (len_1 % i == 0 || len_2 % i == 0){
                String tmp = str1.substring(0,i);
                if(isthesame(str1,tmp) && isthesame(str2,tmp))
                    return tmp;
            }
        }
        return "";
    }

    private boolean isthesame(String str1,String tmp) {
        int count = str1.length() / tmp.length();
        StringBuilder s = new StringBuilder();
        for (int i=0; i<count ;i++)
            s.append(tmp);
        return s.toString().equals(str1);
    }

    //辗转相除法
    public String gcdOfStrings_1(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";
        return str1.substring(0,gcb(str1.length(),str2.length()));
    }

    private int gcb(int length, int length1) {
        return length1==0?length:gcb(length1,length%length1);
    }


    @Test
    public void test() {
        String str1 = "AB";
        String str2 = "AB";
        System.out.println(gcdOfStrings_1(str1, str2));
    }
}
