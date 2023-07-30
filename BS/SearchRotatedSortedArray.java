package BS;
//this is the worst implementation in the history of programming.
//but at least you tried. well...
public class SearchRotatedSortedArray {
    public static void main(String[] args){
        int[] nums = {5,1,3};
        int target = 5;
        int pivot = Pivot(nums);
        int ans = -1;
        if(!isPivot(nums)){
            ans = isPivotFalse( nums, target);
        }
        int ans1 = bSearchOne(nums, target, pivot,true);
        int ans2 = bSearchOne(nums, target, pivot,false);
        System.out.println(ans2);
        if(ans1 != -1){
            ans = ans1;
        }
        else if(ans2 != -1 && ans1 == -1){
            ans = ans2;
        }

        System.out.println(ans);
    }
    static boolean isPivot(int[] nums){
        int first = 0;
        int second = 1;
        while(first < second && second !=nums.length - 1){
            if(nums[first] > nums[second]){
                return true;
            }
            else if(nums[first] < nums[second]){
                first++;
                second++;
            }
        }
        return false;
    }
    static int Pivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }
            else if(nums[mid] > nums[mid + 1]){
                end = mid;
            }
        }
        int pivot = start;
        return pivot;
    }
    static int bSearchOne(int[] nums, int target, int pivot, boolean first){
        int start = 0;
        int end = pivot;

        if(!first){
            start = pivot + 1;
            end = nums.length - 1;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
        }
        return -1;
    }
    static int isPivotFalse(int[] nums, int target){
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
