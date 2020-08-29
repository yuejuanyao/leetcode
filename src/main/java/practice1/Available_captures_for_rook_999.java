package practice1;

public class Available_captures_for_rook_999 {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        if(board == null || board.length<=0 || board[0].length<=0) {
            return res;
        }
        // 查找车的位置
        int[] direction_i = {-1,0,1,0};
        int[] direction_j  ={0,1,0,-1};
        for (int i= 0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 'R'){
                    for (int index= 0; index<direction_i.length; index++){
                        res += check(board, i, j,direction_i[index],direction_j[index]);
                    }
                    return res;
                }
            }
        }
        return res;
    }

    private int check(char[][] board, int R_i, int R_j,int dir_i, int dir_j) {
        while (R_i>0 && R_i <board.length && R_j>0 && R_j<board[0].length){
            char c = board[R_i][R_j];
            if (c == 'B')
                return 0;
            if (c == 'p')
                return 1;
            R_i += dir_i;
            R_j += dir_j;
        }
        return 0;
    }
}
