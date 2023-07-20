package BS;
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class InfiniteBSGlitch {
    public static void main(String[] args){
        //assume that the array is infinite.
        int[] nums = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        int ans = elementRange(nums, target);
        System.out.println("The target element is at " +ans+ " index");

    }
    static int elementRange(int[] nums, int target){
        int start = 0;
        int end = 1;

        while(nums[end] < target){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(nums, target, start, end);
    }
    static int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
