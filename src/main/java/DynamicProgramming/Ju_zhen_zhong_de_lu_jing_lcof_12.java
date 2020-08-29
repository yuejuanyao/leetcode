package DynamicProgramming;

import org.junit.Test;

public class Ju_zhen_zhong_de_lu_jing_lcof_12 {
    int[] xIndex = {0, -1, 0, 1};
    int[] yIndex = {-1, 0, 1, 0};
    String wordConst;
    int length;

    public boolean exist(char[][] board, String word) {
        wordConst = word;
        length = word.length();
        if(length <= 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(board, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, int x, int y, int charIndex) {

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
                board[x][y] != wordConst.charAt(charIndex))
            return false;
        if (charIndex == wordConst.length()-1)
            return true;
        char tmp = board[x][y];
        board[x][y] = '/';
        for (int i = 0; i < 4; i++) {
            int xNew = x + xIndex[i];
            int yNew = y + yIndex[i];
            if (isExist(board, xNew, yNew, charIndex+1)){
                board[x][y] = tmp;
                return true;
            }
        }
        board[x][y] = tmp;
        return false;
    }

    @Test
    public void test(){
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(exist(board, word));
    }
}
