package find;

import java.util.LinkedList;
import java.util.Queue;

public class Ji_qi_ren_de_yun_dong_fan_wei_lcof_13 {
    public int movingCount(int m, int n, int k) {
        if (n == 0)
            return 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] isVisited = new int[m][n];
        isVisited[0][0] = 1;
        queue.offer(new int[]{0, 0});
        int count = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int curX = point[0];
            int curY = point[1];
            count++;
            int rightY = curY+1;
            if(rightY < n && !isOverK(curX,rightY,k) && isVisited[curX][rightY] == 0){
                isVisited[curX][rightY] = 1;
                queue.offer(new int[] {curX, rightY});
            }
            int belowX = curX + 1;
            if (belowX < m  && !isOverK(belowX,curY,k) && isVisited[belowX][curY] == 0){
                isVisited[belowX][curY] = 1;
                queue.offer(new int[] {belowX, curY});
            }
        }
        return count;
    }

    private boolean isOverK(int m, int n, int k) {
        int sum = 0;
        while (m != 0){
            sum += m % 10;
            m /= 10;
        }
        while (n != 0){
            sum+= n % 10;
            n /= 10;
        }
        return sum > k;
    }
}
