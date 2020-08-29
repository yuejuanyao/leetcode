package array;

public class RotateArray_189 {
    public static void rotate(int[] nums, int k) {
        for (int i = k % nums.length; i > 0; i--) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    //利用额外空间
    public static void rotate_1(int[] nums, int k) {
        if (nums == null)
            return;
        int length = nums.length;
        k %= length;
        int[] num_tmp = new int[length];
        System.arraycopy(nums, length - k, num_tmp, 0, k);
        System.arraycopy(nums, 0, num_tmp, k, length - k);
        System.arraycopy(num_tmp, 0, nums, 0, length);
        //或者
//        int[] a = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            a[(i + k) % nums.length] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = a[i];
//        }
    }

    //反转法
    public static void rotate_2(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    //环状旋转法
    public static void rotate_3(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int value_cur = nums[current];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = value_cur;
                current = next;
                value_cur = tmp;
                count++;
            } while (current != i);
        }
    }

    //环状旋转法
    public static void rotate_4(int[] nums, int k) {
        k %= nums.length;
        if (k == 0)
            return;
        int count = 0;
        for (int i = 0; count<nums.length; i++){
            int cur = i;
            int cur_value = nums[cur];
            do{
                int next = (cur + k) % nums.length;
                int tmp = nums[next];
                nums[next] = cur_value;
                cur_value = tmp;
                cur = next;
                count++;
            }while (cur != i);
        }



    }

    public static void main(String[] args) {
        // 1,2,3,4,5,6,7 3 结果 5,6,7,1,2,3,4
        // -1,-100,3,99 2  3,99,-1,-100
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate_4(nums, 2);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
}
