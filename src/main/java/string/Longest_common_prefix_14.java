package string;

public class Longest_common_prefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0)
            return "";
        String tmpCommon = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            while (index<tmpCommon.length() && index < strs[i].length() && tmpCommon.charAt(index) == strs[i].charAt(index)){
                index ++;
            }
            tmpCommon = tmpCommon.substring(0,index);
            if (tmpCommon == "")
                return "";
        }

        return tmpCommon;
    }
    public String longestCommonPrefix_1(String[] strs) {
        if (strs == null || strs.length <= 0)
            return "";
        String tmpCommon = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if(tmpCommon.length() > strs[i].length())
                tmpCommon = strs[i];
        }
        for (int i = 0; i < strs.length; i++) {
            int index = 0;
            while (index<tmpCommon.length() && tmpCommon.charAt(index) == strs[i].charAt(index)){
                index ++;
            }
            tmpCommon = tmpCommon.substring(0,index);
            if (tmpCommon == "")
                return "";
        }

        return tmpCommon;
    }
    public String longestCommonPrefix_2(String[] strs) {
        if (strs == null || strs.length <= 0)
            return "";
        String result = strs[0];
        int minCommon = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (minCommon>strs[i].length()){
                result = strs[i];
                minCommon = result.length();
            }
        }

        while (minCommon > 0){
            boolean flag = true;
            for (String s : strs) {
                if (!s.substring(0,minCommon).equals(result)){
                    minCommon -- ;
                    result = result.substring(0,minCommon);
                    flag = false;
                    break;
                }
            }
            if (flag)
                return result;
        }
        return result;
    }
}
