package practice1;

import org.junit.Test;

public class Er_wei_shu_zu_zhong_de_cha_zhao_lcof_m4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0;
        int j = matrix[0].length-1;
        while (i<matrix.length && j >=0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] nums = {{1,   4,  7, 11, 15},
                        {2,   5,  8, 12, 19},
                        {3,   6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(nums,25));
    }
}
