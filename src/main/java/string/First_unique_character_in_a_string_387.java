package string;

import java.util.Arrays;

public class First_unique_character_in_a_string_387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() <= 0)
            return -1;
        //第一列存储count; 第二列用来存储位置
        int[][] map = new int[26][2];
        for (int i = 0; i < s.length() ;i++){
            int index = s.charAt(i)-'a';
            map[index][0] ++;
            map[index][1] = i;
        }
        int res = s.length();
        for (int i = 0; i<map.length; i++){
            if (map[i][0] == 1 && map[i][1] < res){
                res = map[i][1];
            }
        }
        return res == s.length() ? -1 : res;
    }

    public int firstUniqChar_1(String s) {
        if (s == null || s.length() <= 0)
            return -1;
        //第一列存储count; 第二列用来存储位置
        int[] map = new int[26];
        for (int i = 0; i < s.length() ;i++){
            int index = s.charAt(i)-'a';
            map[index] ++;
        }
        for (int i = 0; i<s.length(); i++){
            if (map[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
