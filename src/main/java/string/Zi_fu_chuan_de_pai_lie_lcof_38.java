package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Zi_fu_chuan_de_pai_lie_lcof_38 {
    List<String> res = new ArrayList<>();
    char[] chars;
    public String[] permutation(String s) {
        if (s.length() <= 0)
            return null;
        chars = s.toCharArray();
        def(0);
       return res.toArray(new String[res.size()]);
    }

    private void def(int i) {
        if (i == chars.length-1)
            res.add(String.valueOf(chars));
        HashSet<Character> set = new HashSet<>();

        for(int next = i; next<chars.length; next++){
            if (set.contains(chars[next]))
                continue;
            set.add(chars[next]);
            swap(i, next);
            def(i+1);
            swap(i, next);
        }
    }

    private void swap(int i, int next) {
        char tmp = chars[i];
        chars[i] = chars[next];
        chars[next] = tmp;
    }

    public char firstUniqChar(String s) {
        if (s==null || s.length()<=0)
            return ' ';
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            int index = c-'a';
            counts[index] ++;
        }
        for(char c : chars){
            if(counts[c-'a'] == 1)
                return c;
        }
        return ' ';
    }
}
