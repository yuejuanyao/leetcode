package array;

public class Rotate_image_48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return;
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < length; i++) {
            int head = 0;
            int tail = matrix.length - 1;
            while (head < tail) {
                int tmp = matrix[i][head];
                matrix[i][head] = matrix[i][tail];
                matrix[i][tail] = tmp;
                tail--;
                head++;
            }
        }
    }

    public void rotate_1(int[][] matrix) {
        //而相隔的两个位置是中心对称的，基于此可以计算出发生交换的四个元素位置关系。
        //设四个位置中，位于左上角区域的位置坐标为 (i,j)，
        //则按顺时针顺序，四个位置分别为(i,j), (j, n-i-1), (n-i-1,n-j-1), (n-j-1,i)。
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return;
        int length = matrix.length;
        for (int i = 0; i< (length+1)/2; i++){
            for (int j = 0; j< length/2; j++){
                int tmp = matrix[length-j-1][i];
                matrix[length-j-1][i] = matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1] = matrix[j][length-i-1];
                matrix[j][length-i-1] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
