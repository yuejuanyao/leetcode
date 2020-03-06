package practice1;

import org.junit.Test;

import java.util.Arrays;

public class Sorted_merge_lcci {

    public void merge(int[] A, int m, int[] B, int n) {
        System.arraycopy(B, 0, A, m, n);
        Arrays.sort(A, 0, m + n);
    }

    public void merge_1(int[] A, int m, int[] B, int n) {
        int i = 0;
        int j = 0;
        while (i < A.length && j < n) {

            if (A[i] < B[j] && i < m + j) {
                i++;
            } else {
                for (int index = A.length - 1; index > i; index--) {
                    A[index] = A[index - 1];
                }
                A[i] = B[j];
                i++;
                j++;
            }
        }
    }

    //从后向前走
    public void merge_2(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0){
            if(A[m-1] > B[n-1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            }else {
                A[m + n - 1] = B[n-1];
                n--;
            }
        }
        // 剩下的数都比已经遍历过的数小
        // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
        // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
        while (n>0){
            A[n-1] = B[n-1];
            n--;
        }
    }

    @Test
    public void test() {
        /*
         * [-1,0,0,3,3,3,0,0,0]
         * 6
         * [1,2,2]
         * 3
         */

        /*
         * [0,0,0]
         * 0
         * [1,2,2]
         * 3
         */
        int[] A = {0, 0, 0, 0};
        int[] B = {2, 3, 4, 5};
        merge_2(A, 0, B, 4);
        for (int x : A) {
            System.out.print(x + ",");
        }
    }
}
