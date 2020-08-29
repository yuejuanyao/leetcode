package find;

public class Zai_pai_xu_shu_zu_zhong_cha_zhao_shu_zi_lcof_53_1 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length <=0)
            return 0;
        return binarySearch(nums, target) - binarySearch(nums, target-1);

    }
    private int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = (start + end)/2;
            if(nums[mid] <= target)
                start = mid + 1;
            else if(nums[mid] > target)
                end = mid -1;
        }
        return start;
    }
    public int majorityElement(int[] nums) {
        int res = 0;
        int vote = 0;
        for(int num : nums ){
            if(vote == 0)
                res = num;
            vote = num == vote ? vote +1: vote - 1;
        }
        return res;
    }
}
