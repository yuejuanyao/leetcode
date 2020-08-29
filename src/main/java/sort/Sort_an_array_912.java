package sort;

import org.junit.Test;

import java.util.Random;

public class Sort_an_array_912 {
    //快排
    public int[] sortArray(int[] nums) {
        if (nums == null)
            return null;
        quickSort_2(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int head, int tail) {
        if (tail <= head)
            return;
        int i = head;
        int j = tail;
        int key = nums[i];
        int tmp;
        while (i < j) {
            while (i < j && key <= nums[j])
                j--;
            if (nums[j] < key) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            while (i < j && key >= nums[i])
                i++;
            if (nums[i] > key) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quickSort(nums, head, i - 1);
        quickSort(nums, j + 1, tail);
    }

    private void quickSort_1(int[] nums, int head, int tail) {
        if (tail <= head)
            return;
        int i = head;
        int j = tail;
        int key = nums[i];
        while (i < j) {
            while (i < j && key <= nums[j])
                j--;
            if (nums[j] < key) {
                nums[i] = nums[j];
            }
            while (i < j && key >= nums[i])
                i++;
            if (nums[i] > key) {
                nums[j] = nums[i];
            }
        }
        nums[i] = key;
        quickSort_1(nums, head, i - 1);
        quickSort_1(nums, j + 1, tail);
    }

    private void quickSort_2(int[] nums, int head, int tail) {
        if (tail <= head)
            return;
        int i = head;
        int j = tail;
        int index = new Random().nextInt(tail-head + 1) + head;
        int tmp = nums[index];
        nums[index] = nums[i];
        nums[i] = tmp;
        int key = nums[i];
        while (i < j) {
            while (i < j && key <= nums[j])
                j--;
            if (nums[j] < key) {
                nums[i] = nums[j];
            }
            while (i < j && key >= nums[i])
                i++;
            if (nums[i] > key) {
                nums[j] = nums[i];
            }
        }
        nums[i] = key;
        quickSort_2(nums, head, i - 1);
        quickSort_2(nums, j + 1, tail);
    }

    @Test
    public void test() {
        int[] nums = {6, 9, 3, 5, 7, 8, 3, 4};
        sortArray(nums);
        for (int x : nums)
            System.out.print(x + ",");
    }
}
