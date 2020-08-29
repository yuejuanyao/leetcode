package practice1;

import org.junit.Test;

public class Find_words_that_can_be_formed_by_characters_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] chars_count = new int[26];
        for (char c : chars.toCharArray()){
            chars_count[c-'a'] +=1;
        }
        int res_count = 0;
        for (String s : words){
            if (check(chars_count,s)){
                res_count += s.length();
                System.out.println(s);
            }
        }
        return res_count;
    }

    private boolean check(int[] chars_count, String s) {
        int[] tmp_count = new int[26];
        for (char c : s.toCharArray()){
            tmp_count[c-'a'] +=1;
            if (tmp_count[c-'a'] > chars_count[c-'a'] ){
                return false;
            }
        }
        for (int i = 0; i<chars_count.length; i++){

            if (tmp_count[i] > chars_count[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String[] strings = {"cata","bt","hat","tree","z"};
        String s = "aatzbc";
        System.out.println(countCharacters(strings,s));
    }
}
