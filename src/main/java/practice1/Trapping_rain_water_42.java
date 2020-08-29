package practice1;

import org.junit.Test;

public class Trapping_rain_water_42 {

    public int trap(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int sumRain = 0;
        int maxHeight = 0;
        for (int value : height) {
            if (value > maxHeight)
                maxHeight = value;
        }
        for (int curHeight = 1; curHeight <= maxHeight; curHeight++) {
            boolean isStart = false;
            int tmpSum = 0;
            for (int i = 0; i < height.length; i++) {
                if (isStart && height[i] < curHeight)
                    tmpSum++;
                if (height[i] >= curHeight) {
                    sumRain += tmpSum;
                    tmpSum = 0;
                    isStart = true;
                }
            }
        }
        return sumRain;
    }
    public int trap_1(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int length = height.length;
        int sumRain = 0;
        for (int i = 0; i< length; i++){
            //左边最大
            int maxLeft = 0;
            for (int j = 0; j<i; j++){
                if (maxLeft < height[j])
                    maxLeft = height[j];
            }
            //右边最大
            int maxRight = 0;
            for (int j = i+1; j<length; j++){
                if (maxRight < height[j])
                    maxRight = height[j];
            }

            int minMax = Math.min(maxLeft,maxRight);
            if (minMax > height[i])
                sumRain += minMax - height[i];

        }
        return sumRain;
    }

    public int trap_2(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int length = height.length;
        int res = 0;
        //左边最大
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        for (int i = 1; i<length; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        //右边最大
        for (int j = height.length-2; j>=0; j--){
            rightMax[j] = Math.max(rightMax[j+1],height[j+1]);
        }

        for (int i = 0; i<height.length; i++){
            int minMax = Math.min(leftMax[i],rightMax[i]);
            if (minMax > height[i])
                res += minMax - height[i];
        }
        return res;
    }
    public int trap_3(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int length = height.length;
        int res = 0;
        int left = 0;
        //右边最大
        int[] rightMax = new int[length];
        for (int j = height.length-2; j>=0; j--){
            rightMax[j] = Math.max(rightMax[j+1],height[j+1]);
        }
        for (int i = 1,j = length-2; i<length; i++){
            left = Math.max(left, height[i - 1]);
            int minMax = Math.min(left,rightMax[i]);
            if (minMax > height[i])
                res += minMax - height[i];
        }
        return res;
    }

    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap_3(height));
    }
}
