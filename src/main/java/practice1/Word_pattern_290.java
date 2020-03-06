package practice1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Word_pattern_290 {
    public boolean wordPattern(String pattern, String str) {
        //注意是双向的
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");
        Map<Character, String > map = new HashMap<>();
        if (chars.length != words.length)
            return false;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                if (!words[i].equals(map.get(chars[i])))
                    return false;
            }else if (!map.containsValue(words[i]))
                map.put(chars[i],words[i]);
            else {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        /*
        "abba"
        "dog dog dog dog"
         */
        //还有一种方法是两边都调用一次，做与运输 ，和Isomorphic_strings_205相同
        String pattern = "aba";
        String str = "dog dog dog";
        System.out.println(wordPattern(pattern,str));
    }
}
