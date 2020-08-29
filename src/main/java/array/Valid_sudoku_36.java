package array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Valid_sudoku_36 {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            int[] count = new int[10];
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.')
                    continue;
                if (count[value - '0'] == 1)
                    return false;
                else
                    count[value - '0'] = 1;
            }
        }

        for (int j = 0; j < 9; j++) {
            int[] count = new int[10];
            for (int i = 0; i < 9; i++) {
                char value = board[i][j];
                if (value == '.')
                    continue;
                if (count[value - '0'] == 1)
                    return false;
                else
                    count[value - '0'] = 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] count = new int[10];
                for (int minI = i * 3; minI < (i + 1) * 3; minI++) {
                    for (int minJ = j * 3; minJ < (j + 1) * 3; minJ++) {
                        System.out.println(minI + " " + minJ);
                        char value = board[minI][minJ];
                        if (value == '.')
                            continue;
                        if (count[value - '0'] == 1)
                            return false;
                        else
                            count[value - '0'] = 1;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku_1(char[][] board) {
        int[][] count_col = new int[10][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            int[] count = new int[10];
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                int boxI = i / 3;
                int boxJ = j / 3;
                int boxIndex = boxI * 3 + boxJ;
                if (value == '.')
                    continue;
                if (count[value - '0'] == 1)
                    return false;
                if (count_col[j][value - '0'] == 1)
                    return false;
                if (box[boxIndex][value - '0'] == 1)
                    return false;
                else {
                    count[value - '0'] = 1;
                    count_col[j][value - '0'] = 1;
                    box[boxIndex][value - '0'] = 1;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '3', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku_1(board));
    }
}
