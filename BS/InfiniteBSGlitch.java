package BS;

public class InfiniteBSGlitch {
    public static void main(String[] args){
        int[] nums = {0,1,2,3,4,5,6,7,8,9,10};
        int target = 9;
    }
    static int elementRange(int[] nums, int target){
        int start = 0;
        int end = 1;

        while(nums[end] < target){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;

        }
    }
}
