package tu;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class As_far_from_land_as_possible_1162 {
    public int maxDistance(int[][] grid) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        if (grid == null || grid.length <= 0|| grid[0].length<=0)
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 1)
                    queue.offer(new int[] {i,j});
            }
        }
        int[] point = null;
        boolean flag = false;
        while (!queue.isEmpty()){
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i<dx.length; i++){
                int curX = x + dx[i];
                int curY = y + dy[i];
                if (curX>=0 && curX < grid.length && curY>=0 && curY<grid[0].length && grid[curX][curY] == 0){
                    grid[curX][curY] = grid[x][y] + 1;
                    flag = true;
                    System.out.println(flag);
                    queue.offer(new int[] {curX, curY});
                }
            }
        }

        if (point == null || !flag)
            return -1;
        return grid[point[0]][point[1]] -1;
    }

    public int maxDistance_1(int[][] grid) {
        int res = -1;
        if (grid == null || grid.length <= 0|| grid[0].length<=0)
            return res;
        for(int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 0)
                    res = Math.max(res, findMin(grid,i,j));
            }
        }
        return res;
    }

    private int findMin(int[][] grid, int i, int j) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j,0});
        int[][] isVisited = new int[grid.length][grid[0].length];
        int[] point = null;
        while (!queue.isEmpty()){
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            int step = point[2];
            for (int index = 0; index<dx.length; index++){
                int curX = x + dx[index];
                int curY = y + dy[index];
                if (curX>=0 && curX < grid.length && curY>=0 && curY<grid[0].length){
                    if (isVisited[curX][curY]==0){
                        if (grid[curX][curY] == 1)
                            return step+1;
                        isVisited[curX][curY] = 1;
                        queue.offer(new int[] {curX, curY, step+1});
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void tests(){
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(maxDistance(grid));
    }
}
