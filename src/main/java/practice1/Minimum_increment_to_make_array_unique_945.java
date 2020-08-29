package practice1;

import org.junit.Test;

import java.util.*;

public class Minimum_increment_to_make_array_unique_945 {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length <= 1)
            return 0;
        int[] map = new int[80000];
        int count = 0;
        for (int x : A) {
            map[x] += 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 1) {
                map[i + 1] += map[i] - 1;
                count += map[i] - 1;
            }
        }
        return count;
    }

    public int minIncrementForUnique_1(int[] A) {
        if (A == null || A.length <= 1)
            return 0;
        int[] map = new int[400000];
        int count = 0;
        int max = map[0];
        for (int x : A) {
            map[x] += 1;
            max = Math.max(max, x);
        }
        for (int i = 0; i < max; i++) {
            if (map[i] > 1) {
                map[i + 1] += map[i] - 1;
                count += map[i] - 1;
            }
        }
        if (map[max] > 1) {
            int d = map[max] - 1;
            count += (1 + d) * d / 2;
            ;
        }
        return count;
    }

    public int minIncrementForUnique_2(int[] A) {
        if (A == null || A.length <= 1)
            return 0;
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int shoulebe = A[i - 1] + 1;
                count += shoulebe - A[i];
                A[i] = shoulebe;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 2, 3, 3, 4};
        String s ="sss";
        s.indexOf('s',4);
        System.out.println(minIncrementForUnique_2(nums));

    }
}
