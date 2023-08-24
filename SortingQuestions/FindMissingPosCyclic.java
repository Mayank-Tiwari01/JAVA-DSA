package SortingQuestions;

public class FindMissingPosCyclic {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,7,8,9};
        System.out.println(missingPos(nums));
    }
    static int missingPos (int[] nums){
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++){
            int correctIndex = nums[i] - 1;

            if(i != correctIndex){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    static int[] cyclicSort (int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n){
            int index = Math.abs(nums[i]) - 1;


            if (nums[i] <= 0 || nums[i] > n) {
                i++;
            }

            else if (nums[i] > 0 && nums[i] <= n && index <= n && nums[i] != nums[index]) {
                swap(nums, i, index);
            }

            else if(nums[i] == nums[index]) {
                i++;
            }

        }
        return nums;
    }

    static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
