package ArrayQuestions;

public class minSizeSubArrContainingMinAndMaxElements {
    public static void main(String[] args) {
        int[] nums = {1,4,6,6,5,1,5,2,6,4,4,2,1,5};
        System.out.println(findMinSizeSubArrContainingMinMax(nums));
    }
    static int findMinSizeSubArrContainingMinMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i > max) max = i;
            else if (i < min) min = i;
        }

        int minIdx = -1, maxIdx = -1, minSize = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) minIdx = i;
            if (nums[i] == max) maxIdx = i;

            if (minIdx != -1 && maxIdx != -1) {
                minSize = Math.min(minSize, Math.abs(maxIdx - minIdx) + 1);
            }
        }
        return minSize;
    }
}
