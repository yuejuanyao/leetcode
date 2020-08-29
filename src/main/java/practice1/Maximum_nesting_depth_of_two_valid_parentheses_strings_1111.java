package practice1;

public class Maximum_nesting_depth_of_two_valid_parentheses_strings_1111 {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null)
            return new int[0];
        int[] res = new int[seq.length()];
        int depth = 0;
        for (int i=0; i< seq.length(); i++){
            if (seq.charAt(i) == '('){
                depth++;
                res[i] = depth%2;
            }else {
                res[i] = depth%2;
                depth--;
            }
        }
        return res;
    }
}
