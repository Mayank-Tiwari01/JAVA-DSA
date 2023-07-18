package BS;

public class bSearch {
    public static void main(String args[]){
        int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        // int [] nums = {18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};

        int target = 11;

        int ans = Result(nums, target);

        if(ans == -1){
            System.out.println("The Desired element is not present in the array");
        }
        else{
            System.out.println(ans);
        }

        
    }

    static int Result(int nums[], int target){
        int start = 0;
        int end = nums.length - 1;

        boolean isAsc = nums[0] < nums[nums.length - 1];

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }

            else if(isAsc){
                if(nums[mid] < target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            else{
                if(nums[mid] < target){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
