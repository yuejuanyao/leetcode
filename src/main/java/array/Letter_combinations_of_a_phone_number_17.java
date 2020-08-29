package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Letter_combinations_of_a_phone_number_17 {
    char[][] map = new char[8][];
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() <= 0)
            return list;
        map[0] = new char[]{'a','b','c'};
        map[1] = new char[]{'d','e','f'};
        map[2] = new char[]{'g','h','i'};
        map[3] = new char[]{'j','k','l'};
        map[4] = new char[]{'m','n','o'};
        map[5] = new char[]{'p','q','r','s'};
        map[6] = new char[]{'t','u','v'};
        map[7] = new char[]{'w','x','y','z'};
        dep(digits, 0, new StringBuilder());
        return list;
    }

    private void dep(String digits, int index, StringBuilder pre) {
        if (index == digits.length()){
            list.add(pre.toString());
            return;
        }
        int mapKey = digits.charAt(index) - '2';
        for (int i = 0; i < map[mapKey].length; i++) {
            StringBuilder tmp = new StringBuilder(pre);
            dep(digits, index + 1, tmp.append(map[mapKey][i]));
        }
    }
}
