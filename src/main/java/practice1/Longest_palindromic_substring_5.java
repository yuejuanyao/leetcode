package practice1;

import org.junit.Test;

public class Longest_palindromic_substring_5 {
    //方法1 暴力法
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0)
            return "";

        String cur_string = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i + 1 > cur_string.length()) {
                    cur_string = cur_string.length() > chack(s, i, j) ? cur_string : s.substring(i, j + 1);
                }
            }
        }
        return cur_string;
    }

    private int chack(String s, int i, int j) {
        int head = i;
        int tail = j;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail))
                return -1;
            head++;
            tail--;
        }
        return j - i + 1;
    }
    //动态规划法
    public String longestPalindrome_1(String s) {
        if (s == null || s.length() <= 1)
            return s;
        boolean[][] is_pa= new boolean[s.length()][s.length()];
        String s_res = "";
        int max_length = 1;
        int string_begin = 0;
        for (int len = 1; len < s.length(); len++){
            for (int start = 0; start < len; start++){
                if (s.charAt(start) == s.charAt(len)){
                    is_pa[start][len] = len - start < 3 || is_pa[start + 1][len - 1];
                }else {
                    is_pa[start][len] =false;
                }
                if (is_pa[start][len]){
                    int cur_length = len - start +1;
                    if (cur_length > max_length){
                        string_begin = start;
                        max_length = cur_length;
                    }
                }
            }
        }
        return s.substring(string_begin,string_begin+max_length);
    }

    //中心扩展算法
    public String longestPalindrome_2(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int max_length = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i<s.length(); i++){
            int tmp_len_1 = enpendCenter(s,i,i);
            int tmp_len_2 = enpendCenter(s,i,i+1);
            int tmp_max = Math.max(tmp_len_1,tmp_len_2);

            if (max_length < tmp_max){
                max_length = tmp_max;
                start = i - (max_length -1)/2;
                end = i + max_length /2;
            }
        }
        return s.substring(start,end+1);
    }

    private int enpendCenter(String s, int i, int j) {
        while (i >= 0 && j< s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i -1;
    }

    @Test
    public void test() {
        String s = "aadffdbad";
        //System.out.println(chack(s,0,0));
        System.out.println(longestPalindrome_2(s));
    }
}
