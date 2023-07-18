// package BS;

// public class  FirstandLastPosition {
//     public static void main(String[] args) {
//         int [] nums = {5,7,7,8,8,10};
//         int target = 8;
        
//         int[] ans = searchRange(nums, target);
//         System.out.println(ans);

//     }

//     public static int[] searchRange(int[] nums, int target){
//         int length = nums.length;

//         int start = 0;
//         int end = length - 1;
//         int ans1 = -1;
//         int ans2 = -1;

//         while(start <= end){
//             int mid = start + (end - start) / 2;

//             if(nums[mid] == target){
//                 int start1 = 0;
//                 int end1 = mid - 1;

//                 int start2 = mid + 1;
//                 int end2 = length - 1;

//                 int mid1 = start1 + (end1 - start1) / 2;

//                  if(nums[mid1] == target){
//                     ans1 = mid1;
//                 }

//                 else if(nums[mid1] < target){
//                     start1 = mid1 + 1;
//                 }

//                 else if(nums[mid1] > target){
//                     end1 = mid - 1;
//                 }

//                 int mid2 = start2 + (end2 - start2) / 2;
//                  if(nums[mid2] == target){
//                     ans2 = mid2;
//                 }

//                 else if(nums[mid2] < target){
//                     start2 = mid2 + 1;
//                 }

//                 else if(nums[mid2] > target){
//                     end2 = mid2 - 1;
//                 }

//             else if(nums[mid] < target){
//                 start = mid + 1;
//             }

//             else{
//                 end = mid - 1;
//             }

//             }
//         }

//         int[] result = {ans1, ans2};
//         return result;
//     }
// }
