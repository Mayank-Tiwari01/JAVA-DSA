package ArrayQuestions;
/*
meh
https://www.youtube.com/watch?v=ZI2z5pq0TqA
 */
public class TrappingRainWaterConstantSpace {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }
    static int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0;
        int left = 0, right = len - 1;
        int leftMax = height[left], rightMax = height[right];

        int totalWater = 0;
        while(left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(height[left], leftMax);
                totalWater += Math.max(0, leftMax - height[left]);
            }
            else {
                right--;
                rightMax = Math.max(height[right], rightMax);
                totalWater += Math.max(0, rightMax - height[right]);
            }
        }
        return totalWater;
    }
}
