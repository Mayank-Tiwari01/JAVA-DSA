package RecursionAndBacktracking;

public class searchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2,3,4};
        System.out.println(RBS(arr, 0, arr.length - 1, 4));
    }
    static int RBS(int[] arr, int start, int end, int target) {
        if (start > end)
            return - 1;
        int mid = start + (end - start) / 2;

        if (arr[mid] == target)
            return mid;

        if (arr[mid] >= arr[start]) {
            if (target < arr[mid] && target >= arr[start])
                return RBS(arr, start, mid - 1, target);
            else
                return RBS(arr, mid + 1, end, target);
        }
        else {
            if (arr[mid] < target && target <= arr[end])
                return RBS(arr, mid + 1, end, target);
            else
                return RBS(arr, start, mid - 1, target);
        }
    }
}
