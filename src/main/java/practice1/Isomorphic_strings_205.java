package practice1;

import java.util.HashMap;

public class Isomorphic_strings_205 {

    public boolean isIsomorphic(String s, String t) {
        //注意要两个都做检查 s = ab, t = cc
        return isSimple(s,t) && isSimple(t,s);
    }

    private boolean isSimple(String s, String t){
        HashMap<Character,Character> map = new HashMap<>();
        if(s==null || s.length()==0){
            return true;
        }
        int length = s.length();
        for (int i=0; i<length; i++){
            char s_ = s.charAt(i);
            char t_ = t.charAt(i);
            if(!map.containsKey(s_)){
                map.put(s_,t_);
            }else {
                if(map.get(s_) != t_){
                    return false;
                }
            }
        }
        return true;
    }
}
