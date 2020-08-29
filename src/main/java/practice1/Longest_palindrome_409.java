package practice1;

import org.junit.Test;

public class Longest_palindrome_409 {
    /*
    注意有ccc这种
     */
    public int longestPalindrome(String s) {
        int[] hash = new int['z' -'A'+1];
        int count = 0;
        if (s==null || s.length()<=0)
            return count;
        for (char c : s.toCharArray()){
            int index = c-'A';
            if (index<0 || index >= hash.length || (index>'Z'-'A' && index < 'a'-'A'))
                throw new RuntimeException("字符串包含其他字符");
            hash[index] += 1;
        }
        boolean has_one = false;
        for (int i : hash){
            if (i % 2 == 0)
                count+=i;
            else{
                count += i / 2 * 2;
                has_one = true;
            }
        }
        return has_one ? count +1 : count;

//        int[] count = new int[128];
//        for (char c: s.toCharArray())
//            count[c]++;
//
//        int ans = 0;
//        for (int v: count) {
//            ans += v / 2 * 2;
//            if (v % 2 == 1 && ans % 2 == 0)
//                ans++;
//        }
//        return ans;
    }

    @Test
    public void test(){
        System.out.println('Z'-'A');
        System.out.println('a'-'A');
        String s = "aabbbabcccc";
        System.out.println(longestPalindrome(s));
    }

}
