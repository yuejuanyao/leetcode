package string;

public class Implement_strstr_28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null)
            return -1;
        if (needle == null || needle.length() <= 0)
            return 0;
        int hayLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i <= hayLength - needle.length(); i++) {
            int curHay = i;
            int curNeed = 0;
            while (curHay < hayLength && curNeed < needleLength && haystack.charAt(curHay) == needle.charAt(curNeed)) {
                curHay++;
                curNeed++;
            }
            if (curNeed == needleLength)
                return i;
        }
        return -1;
    }

    public int strStr_1(String haystack, String needle) {
        if (haystack == null)
            return -1;
        if (needle == null || needle.length() <= 0)
            return 0;
        int i = 0;
        int j = 0;
        int lengthHay = haystack.length();
        int lengthNeed = needle.length();
        while (i <= lengthHay && j <= lengthNeed) {
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                i = i-j +1;
                j = 0;
            }
        }
        if (j > lengthNeed){
            return i-j;
        }
        return -1;
    }
}
