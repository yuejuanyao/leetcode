package array;

import org.junit.Test;

public class Game_of_life_289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[][] status = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int surroundAlive = 0;
                for (int index = 0; index < dx.length; index++) {
                    int curX = i + dx[index];
                    int curY = j + dy[index];
                    if (curX >= 0 && curX < row && curY >= 0 && curY < col && board[curX][curY] == 1) {
                        surroundAlive++;
                    }
                }
                System.out.println(surroundAlive);
                if (board[i][j] == 0 && surroundAlive == 3)
                    status[i][j] = 1;
                if (board[i][j] == 1 && (surroundAlive > 3 || surroundAlive < 2)) {
                    status[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (status[i][j] != 0)
                    board[i][j] += status[i][j];
            }
        }

    }

    public void gameOfLife_1(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int surroundAlive = 0;
                for (int index = 0; index < dx.length; index++) {
                    int curX = i + dx[index];
                    int curY = j + dy[index];
                    if (curX >= 0 && curX < row && curY >= 0 && curY < col) {
                        surroundAlive += (board[curX][curY] & 1);
                    }
                }
                System.out.println(surroundAlive);
                if (board[i][j] == 0 && surroundAlive == 3)
                    board[i][j] |= 2;
                if (board[i][j] == 1 && (surroundAlive == 3 || surroundAlive == 2)) {
                    board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                    board[i][j] >>= 1;
            }
        }

    }
    @Test
    public void test(){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife_1(board);
    }
}
