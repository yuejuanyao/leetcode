package find;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Max_area_of_island_695 {
    int[] index_i = {0, -1, 0, 1};
    int[] index_j = {-1, 0, 1, 0};
    //方法1 深度优先遍历，递归
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0)
            return 0;
        int max_area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max_area = Math.max(max_area, dfs(grid, i, j));
                }
            }
        }
        return max_area;
    }

    private int dfs(int[][] grid, int i, int j) {
        int curr_area = 1;
        grid[i][j] = 0;
        for (int index = 0; index < index_i.length; index++) {
            int cur_i = i + index_i[index];
            int cur_j = j + index_j[index];
            if (cur_i >= 0 && cur_i < grid.length && cur_j >= 0 && cur_j < grid[0].length && grid[cur_i][cur_j] == 1)
                curr_area += dfs(grid, cur_i, cur_j);
        }
        return curr_area;
    }
    //深度优先遍历，队列
    public int maxAreaOfIsland_1(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0)
            return 0;
        int max_area = 0;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int tmp_area = 0;
                    queue.offer(new Pair<>(i,j));
                    while (!queue.isEmpty()){
                        Pair<Integer,Integer> pair = queue.poll();
                        tmp_area +=1;
                        for (int index = 0; index < index_i.length; index++) {
                            int cur_i = pair.getKey() + index_i[index];
                            int cur_j = pair.getValue() + index_j[index];
                            if (cur_i >= 0 && cur_i < grid.length && cur_j >= 0 && cur_j < grid[0].length && grid[cur_i][cur_j] == 1){
                                grid[cur_i][cur_j] = 0;
                                queue.offer(new Pair<>(cur_i,cur_j));
                            }
                        }
                    }
                    max_area = Math.max(max_area, tmp_area);
                }
            }
        }
        return max_area;
    }

    @Test
    public void test(){
        int[][] nums = {{0,1,0},{0,1,1},{0,0,1}};
        System.out.println(maxAreaOfIsland_1(nums));
    }
}
