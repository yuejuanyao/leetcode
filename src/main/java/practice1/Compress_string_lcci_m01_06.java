package practice1;

import org.junit.Test;

public class Compress_string_lcci_m01_06 {

    public String compressString(String S) {
        if (S == null || S.length()<=0)
            return "";
        int curr_count = 0;
        char curr_c = S.charAt(0);
        StringBuilder s_res = new StringBuilder();
        for (char c : S.toCharArray()){
            if (c == curr_c){
                curr_count++;
            }else {
                s_res.append(curr_c);
                s_res.append(curr_count);
                curr_c = c;
                curr_count = 1;
            }
        }
        s_res.append(curr_c);
        s_res.append(curr_count);
        String s_res_string = s_res.toString();
        System.out.println(s_res_string);
        return s_res_string.length() < S.length() ? s_res_string : S;
    }

    @Test
    public void test(){
        String s = "abbccc";
        System.out.println(compressString(s));
    }
}
