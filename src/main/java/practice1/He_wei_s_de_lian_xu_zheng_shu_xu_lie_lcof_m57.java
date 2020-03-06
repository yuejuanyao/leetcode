package practice1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class He_wei_s_de_lian_xu_zheng_shu_xu_lie_lcof_m57 {
    //暴力法
    public int[][] findContinuousSequence(int target) {

        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            int sum = 0;
            int index = 0;
            int[] tmp = new int[target / 2 + 1];
            for (int j = i; j <= target / 2 + 1; j++) {
                tmp[index++] = j;
                sum += j;
                if (sum > target) {
                    break;
                }
                if (sum == target) {
                    list.add(Arrays.copyOf(tmp, index));
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    //滑动窗口
    public int[][] findContinuousSequence_1(int target) {

        List<int[]> list = new ArrayList<>();
        int i = 1;
        int j = 1;
        int sum = 0;
        //注意是左闭右开，所以j是小于(target/2)+2
        while (i <= target / 2 && j<=(target/2)+2) {
            if (sum < target) {
                sum += j;
                j++;
            }else if (sum > target){
                sum -= i;
                i++;
            }else {
                int[] tmp = new int[j-i];
                for (int index=0;index<tmp.length;index++){
                    tmp[index] = index+i;
                }
                list.add(tmp);
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    @Test
    public void test() {
        int[][] temp = findContinuousSequence_1(9);
        for (int[] nums : temp) {
            for (int x : nums) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
