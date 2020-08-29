package practice1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Reverse_vowels_of_a_string_345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1)
            return s;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = chars.length - 1;
        char tmp;
        while (i<j){
            boolean is_i = set.contains(chars[i]);
            boolean is_j = set.contains(chars[j]);
            if (!is_i)
                i++;
            if(!is_j)
                j--;
            if (is_i && is_j){
                tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }

        return String.valueOf(chars);
    }
    @Test
    public void test(){
        String s = new String("test");

        String s_ = s.toUpperCase();
        System.out.println(s_);
    }
}
