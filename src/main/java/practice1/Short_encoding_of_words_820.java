package practice1;

import org.junit.Test;

import java.util.*;

public class Short_encoding_of_words_820 {
    public int minimumLengthEncoding(String[] words) {
        int count = 0;
        if (words == null || words.length <= 0)
            return count;
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : set) {
            for (int i = 1; i < word.length(); i++) {
                if (set.contains(word.substring(i))) {
                    set.remove(word.substring(i));
                }
            }
        }
        for (String word : set) {
            count += word.length() + 1;
        }
        return count;
    }

    public int minimumLengthEncoding_1(String[] words) {
        int count = 0;
        if (words == null || words.length <= 0)
            return count;

        return count;
    }

    @Test
    public void test() {
        String[] words = {"time", "be", "ime", "atime", "bell"};
        System.out.println(minimumLengthEncoding_1(words));
    }
}
