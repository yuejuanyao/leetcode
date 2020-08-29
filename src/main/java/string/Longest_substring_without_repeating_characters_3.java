package string;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_substring_without_repeating_characters_3 {
    //方法1，暴力法，监察每个子字符串是否有重复，有重复的函数可以用set来实现，然后更新最大的长度
    //方法二，滑动窗口法，可以用set来充当滑动窗口，左闭右开[)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int i = 0;
        int max_length = 0;
        for (int j = 0; j < s.length();) {
            if (!window.contains(s.charAt(j))) {
                window.add(s.charAt(j++));
                max_length = Math.max(max_length, window.size());
            } else {
                window.remove(s.charAt(i++));
            }
        }
        return max_length;
    }

    public int lengthOfLongestSubstring_1(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int i = 0;
        int max_length = 0;
        for (int j = 0; j < s.length(); j++) {
            if (window.containsKey(s.charAt(j))) {
                i = Math.max(i,window.get(s.charAt(j)) + 1);
             }
            window.put(s.charAt(j),j);
            max_length = Math.max(max_length, j-i+1);//因为j++，所以应该一直比较
        }
        return max_length;
    }

    public int lengthOfLongestSubstring_(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        int maxLegth = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> set = new HashSet<>();
        while(end < s.length()){
            char cur = s.charAt(end);
            while(set.contains(cur)){
                maxLegth = Math.max(maxLegth, end-start);
                set.remove(s.charAt(start++));
            }
            set.add(cur);
            end ++;
        }
        maxLegth = Math.max(maxLegth, end-start);
        return maxLegth;
    }

    @Test
    public void test() {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring_1(s));
    }
}
