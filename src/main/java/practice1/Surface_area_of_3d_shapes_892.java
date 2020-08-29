package practice1;

import org.junit.Test;

import java.util.ArrayList;

public class Surface_area_of_3d_shapes_892 {
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0)
            return 0;

        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                area += countThisArea(grid, i, j);
            }
        }
        return area;
    }

    private int countThisArea(int[][] grid, int i, int j) {
        int[] neighbour_i = {-1, 0, 1, 0};
        int[] neighbour_j = {0, 1, 0, -1};
        int n = grid[i][j];

        int shouldDelete = n > 0 ? (n - 1) * 2 : 0;
        for (int index = 0; index < neighbour_i.length; index++) {
            int cur_i = i + neighbour_i[index];
            int cur_j = j + neighbour_j[index];
            if (cur_i >= 0 && cur_i < grid.length && cur_j >= 0 && cur_j < grid[0].length) {
                shouldDelete += Math.min(n, grid[cur_i][cur_j]);
            }
        }
        return n * 6 - shouldDelete;
    }

    public int surfaceArea_1(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0)
            return 0;

        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int n = grid[i][j];
                if (n > 0) {
                    area += n * 6 - (n - 1) * 2;
                    if (i > 0) {
                        area -= Math.min(n, grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        area -= Math.min(n, grid[i][j - 1]) * 2;
                    }
                }
            }
        }
        return area;
    }

    @Test
    public void test() {
        int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(surfaceArea_1(grid));
        Object[] test = new Object[20];
        test[0] = 10;
        test[5] = 20;
        int index = 0;
        int itest = 5;
        System.out.println((Integer) test[index = itest]);
    }
}
