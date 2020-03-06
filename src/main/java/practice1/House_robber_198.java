package practice1;

public class House_robber_198 {
    public static int rob(int[] nums) {
        int sumevn = 0;
        int sumood = 0;
        if(nums == null || nums.length<=0){
            return sumevn;
        }
        int length = nums.length;
        for(int i=0; i<length; i++){
            if(i%2==0){
                sumevn += nums[i];
                sumevn = Math.max(sumevn,sumood);
            }
            if(i%2!=0){
                sumood += nums[i];
                sumood = Math.max(sumevn,sumood);
            }
        }
        return Math.max(sumevn, sumood);
    }

    public static int rob_1(int[] nums) {
        int premax = 0;
        int curmax = 0;
        for (int num : nums) {
            int tmp = curmax;
            curmax = Math.max(premax + num, curmax);
            premax = tmp;
        }
        return curmax;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        System.out.println(rob_1(nums));
    }
}
