package tu;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Rotting_oranges_994 {
    public int orangesRotting(int[][] grid) {
        //计算格子的上下左右
        int[] next_r = {0,-1,0,1};
        int[] next_c = {-1,0,1,0};
        int row = grid.length;
        int colum = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        //将0时刻发霉的放入队列；
        for (int i = 0; i<row; i++){
            for (int j = 0; j<colum; j++){
                if (grid[i][j] == 2){
                    queue.add(i*colum + j);
                    depth.put(i*colum + j,0);
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()){
            Integer code = queue.poll();
            int row_code = code / colum;
            int colum_code = code % colum;
            int dep = depth.get(code);
            for (int i=0; i<next_c.length;i++){
                int next_row = row_code + next_r[i];
                int next_col = colum_code+next_c[i];
                if(next_row >=0 && next_row< row && next_col >= 0 && next_col<colum && grid[next_row][next_col] == 1){
                    grid[next_row][next_col] = 2;
                    time = dep + 1;
                    queue.add(next_row*colum + next_col);
                    depth.put(next_row*colum + next_col,time);
                }
            }
        }
        for (int[] rows : grid){
            for (int x: rows){
                if (x == 1)
                    time = -1;
            }
        }
        return time;
    }
    public int orangesRotting_1(int[][] grid) {
        class Node{
            int code;
            int dep;
            public Node(int code, int dep){
                this.code = code;
                this.dep = dep;
            }
        }
        //计算格子的上下左右
        int[] next_r = {0,-1,0,1};
        int[] next_c = {-1,0,1,0};
        int row = grid.length;
        int colum = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        //将0时刻发霉的放入队列；
        for (int i = 0; i<row; i++){
            for (int j = 0; j<colum; j++){
                if (grid[i][j] == 2){
                    queue.add( new Node(i*colum + j,0));
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            Integer code = cur.code;
            int row_code = code / colum;
            int colum_code = code % colum;
            int dep = cur.dep;
            for (int i=0; i<next_c.length;i++){
                int next_row = row_code + next_r[i];
                int next_col = colum_code+next_c[i];
                if(next_row >=0 && next_row< row && next_col >= 0 && next_col<colum && grid[next_row][next_col] == 1){
                    grid[next_row][next_col] = 2;
                    time = dep + 1;
                    queue.add(new Node(next_row*colum + next_col,time));
                }
            }
        }
        for (int[] rows : grid){
            for (int x: rows){
                if (x == 1)
                    time = -1;
            }
        }
        return time;
    }

    @Test
    public void test(){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting_1(grid));
    }
}
