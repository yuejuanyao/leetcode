package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

    //省空间的
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a'] -= 1;
            if (counts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char);
        Arrays.sort(t_char);
        for (int i = 0; i < s.length(); i++) {
            if (s_char[i] != t_char[i])
                return false;
        }

        return true;
    }

    //最快的最浪费空间的
    public boolean isAnagram_3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        int[] in1 = new int[26];
        boolean flag = true;
        for (char c : s_char) {
            in1[c - 'a']++;
        }
        for (char c1 : t_char) {
            in1[c1 - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (in1[i] != 0) {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean isAnagramB(String s, String t) {

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram_2("abb", "bab"));
    }

}
