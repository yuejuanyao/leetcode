package practice1;

public class TwoSum_ii_inputArrayIsSorted_167 {

    public static int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if(numbers[head] + numbers[tail] == target){
                return new int[]{++head, ++tail};
            }else if(numbers[head] + numbers[tail] > target) {
                tail --;
            }else {
                head ++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums,10);
    }
}
