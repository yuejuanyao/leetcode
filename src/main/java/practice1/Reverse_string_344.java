package practice1;

public class Reverse_string_344 {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1)
            return;
        int i = 0;
        int j = s.length - 1;
        char tmp;
        while (i<j){
            if(s[i] == s[j]){
                i++;
                j--;
                continue;
            }
            tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}
