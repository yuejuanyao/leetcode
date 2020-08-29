package practice1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class X_of_a_kind_in_a_deck_of_cards_914 {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] map = new int[10000];
        for (int x : deck) {
            map[x] += 1;
        }
        int tmp = map[0];
        for (int j = 1; j < map.length; j++) {
            tmp = gcb(tmp, map[j]);
            if (tmp == 1)
                return false;
        }
        return true;
    }
    private int gcb(int a, int b){
        if (b == 0)
            return a;
        return gcb(b, a%b);
    }

    @Test
    public void test(){
        System.out.println( );
    }
}
