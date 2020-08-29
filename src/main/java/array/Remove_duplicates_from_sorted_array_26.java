package array;

public class Remove_duplicates_from_sorted_array_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length<=0)
            return 0;
        int i = 0;
        int length = nums.length;
        while (i<length-1){
            if (nums[i] == nums[i+1]){
                int j = i;
                while (j<length-1){
                    nums[j] = nums[j+1];
                    j++;
                }
                length--;
            }else {
                i++;
            }
        }
        return length;
    }

    public int removeDuplicates_1(int[] nums) {
        if (nums == null || nums.length<=0)
            return 0;
        int i = 0;
        for (int j = 1; j<nums.length; j++){
            if (nums[j]!= nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}
