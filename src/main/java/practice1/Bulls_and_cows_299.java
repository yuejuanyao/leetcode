package practice1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Bulls_and_cows_299 {
    public String getHint(String secret, String guess) {
        int A=0;
        int B=0;
        Map<Character,Integer> map = new HashMap<>();

        for (char c : secret.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c,1);
            }else {
                map.replace(c,map.get(c)+1);
            }
        }
        for (int i=0; i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                A++;
                if (map.get(s) <=0){
                    B--;
                }else {
                    map.replace(s,map.get(s)-1);
                }
            }else if (map.containsKey(g) && map.get(g)>0){
                B++;
                map.replace(g,map.get(g)-1);
            }
        }
        return String.valueOf(A) + "A" + String.valueOf(B) + "B";
    }

    public String getHint_1(String secret, String guess) {
        int A=0;
        int B=0;
        int[] map = new int[10];
        for (int i=0; i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g){
                A++;
                continue;
            }
            map[s-'0'] += 1;
            map[g-'0'] -= 1;
        }
        int not_guess = 0;
        for (int x : map){
            if (x > 0){
                not_guess+=x; //这个要注意
            }
        }
        B = guess.length()-A-not_guess;
        return String.valueOf(A) + "A" + String.valueOf(B) + "B";
    }
    @Test
    public void test(){
        // 注意如"1122" "1222"
        System.out.println(getHint_1("1122", "3456"));
    }
}
