package practice1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zigzag_conversion_6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <=1 )
            return s;
        if (numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i< Math.min(s.length(),numRows); i++){
            rows.add(new StringBuilder());
        }
        int turn_direction = -1;
        int row_index = 0;
        for (char c : s.toCharArray()){
            rows.get(row_index).append(c);
            if (row_index == 0 || row_index == numRows-1)
                turn_direction = - turn_direction;
            row_index += turn_direction;
        }
        StringBuilder res = new StringBuilder();
        for ( StringBuilder st : rows)
            res.append(st);
        return res.toString();
    }
}
